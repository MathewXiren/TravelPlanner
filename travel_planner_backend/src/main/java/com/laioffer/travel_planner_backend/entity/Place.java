package com.laioffer.travel_planner_backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "places")
public class Place implements Serializable {

    private static final long serialVersionUID = 4416791690796518229L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String placeId;

    private String name;

    private double longitude;

    private double latitude;

    @Enumerated(EnumType.STRING)
    private PlaceCategory category;

    private String address;

    @ManyToOne
    private City city;

    private String state;

    private String country;

    private String postcode;

    private java.sql.Time openTime;

    private java.sql.Time closeTime;

    @Column(name = "place_rating")
    private double rating;

    private String description;

    @ElementCollection
    private List<String> review = new ArrayList<>();

    private String url;

    private Double price;

    @ManyToMany(mappedBy = "placesVisited")
    private List<User> pastVisitors = new ArrayList<>();

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public PlaceCategory getCategory() {
        return category;
    }

    public void setCategory(PlaceCategory category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getReview() {
        return review;
    }

    public void setReview(List<String> review) {
        this.review = review;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<User> getPastVisitors() {
        return pastVisitors;
    }

    public void setPastVisitors(List<User> pastVisitors) {
        this.pastVisitors = pastVisitors;
    }
}
