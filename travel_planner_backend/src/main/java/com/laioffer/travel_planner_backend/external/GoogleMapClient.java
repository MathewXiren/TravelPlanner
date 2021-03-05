package com.laioffer.travel_planner_backend.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.travel_planner_backend.entity.Place;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleMapClient {
    
    private static final String SEARCH_BY_ID_TEMPLATE =
        "https://maps.googleapis.com/maps/api/place/details/json?placeid=%s&fields=%s&key=%s";
    private static final String SEARCH_BY_NAME_TEMPLATE =
        "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s&key=%s";
    private static final String SEARCH_NEARBY_TEMPLATE =
        "https://maps.googleapis.com/maps/api/place/textsearch/json?query=&location=%s&radius=%s&type=%s&key=%s";
    
    @Value("${external.googleMapKey}")
    private String key;
    
    public Place searchByID(String place_id) throws GoogleMapException {
        place_id = URLEncoder.encode(place_id, StandardCharsets.UTF_8);
        List<String> fields = new ArrayList<>(
            Arrays.asList("name", "address_components", "formatted_address",
                "formatted_phone_number", "geometry", "opening_hours", "place_id", "url", "rating",
                "types", "reviews", "photos"));
        String searchURL = String
            .format(SEARCH_BY_ID_TEMPLATE, place_id, String.join(",", fields), key);
        // System.out.println(searchURL);
        String searchResult = searchGoogleMap(searchURL);
        JSONObject resJSON = new JSONObject(searchResult);
        return getPlace(resJSON.get("result").toString());
    }
    
    
    public List<Place> searchByName(String input, String city) throws GoogleMapException {
        input = URLEncoder.encode(input + " " + city, StandardCharsets.UTF_8);
        String searchURL = String.format(SEARCH_BY_NAME_TEMPLATE, input, key);
        // System.out.println(searchURL);
        String searchResult = searchGoogleMap(searchURL);
        JSONObject resJSON = new JSONObject(searchResult);
        return getPlaceList(resJSON.get("results").toString());
    }
    
    
    private Place getPlace(String data) throws GoogleMapException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, Place.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new GoogleMapException("Failed to parse game data from Google Map API");
        }
    }
    
    private List<Place> getPlaceList(String data) throws GoogleMapException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, new TypeReference<List<Place>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new GoogleMapException("Failed to parse game data from Google Map API");
        }
    }
    
    
    private String searchGoogleMap(String url) throws GoogleMapException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // Define own response Handler (returns the "data" value in jsonarray as strings)
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status != 200) {
                throw new GoogleMapException("Failed to get data from Google Map API!");
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new GoogleMapException("Failed to get data from Google Map API!");
            }
            JSONObject obj = new JSONObject(EntityUtils.toString(entity));
            // System.out.println(obj.toString());
            return obj.toString();
        };
        
        try {
            HttpGet request = new HttpGet(url);
            return httpclient.execute(request, responseHandler);
        } catch (IOException e) {
            throw new GoogleMapException("Failed to get data from Google Map API!");
        } finally {
            // Clean up
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Place> searchNearby(String locStr, int rad, String type) {
        String searchURL = String.format(SEARCH_NEARBY_TEMPLATE, locStr, rad, type, this.key);
        System.out.println(searchURL);
        String searchResult = searchGoogleMap(searchURL);
        JSONObject resJSON = new JSONObject(searchResult);
        return getPlaceList(resJSON.get("results").toString());
    }
}
