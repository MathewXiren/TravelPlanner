import React from 'react';
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';
// import '../styles/App.css';
import PlannerPage from './PlannerPage';
import HomePage from './HomePage';
import LoginPage from './LoginPage';
import SignUpPage from './SignUpPage';
import { useState } from 'react';

const App = () => {

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [token, setToken] = useState(null);
  const [trips, setTrip] = useState(null);
  const [curTrip, setCurTrip] = useState(null);
  
  const onLoggedInStatus = (loggin, data) => {
      setIsLoggedIn(loggin);
      setToken(data.accessToken);
      setTrip(data.trips);
  }
  const onCurTrip = (curTrip) => {
      setCurTrip(curTrip);
  }

  return (
  <div className="App">


    <Router>
      <div>
        {/* <Layout>
          {/* <TravelHeader /> */}
          {/* <nav>
            <ul>
              <li>
                <Link to="/">HomePage</Link>
              </li>
              <li>
                <Link to="/planner">PlannerPage</Link>
              </li>
            </ul>
          </nav> */}
        {/* </Layout> */}
         {/* */}
        
          {/* comm */}
        <Switch>
          <Route path="/planner">
            <PlannerPage isLoggedIn={isLoggedIn}
                         token={token}
                         curTrip={curTrip}
            />
          </Route>
          <Route path="/login">
            <LoginPage onLoggedInStatus={onLoggedInStatus}
                       onCurTrip={onCurTrip}      
                      />
          </Route>
          <Route path="/signup">
            <SignUpPage />
          </Route>
          <Route path="/">
            <HomePage onLoggedInStatus={onLoggedInStatus}
                      isLoggedIn={isLoggedIn}
                      token={token}
                      trips={trips}
                      onCurTrip={onCurTrip}        
            />
          </Route>
        </Switch>
      </div>
    </Router>
  </div>
  )
};

export default App;