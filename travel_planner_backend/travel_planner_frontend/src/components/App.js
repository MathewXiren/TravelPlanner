import React from 'react';
import Header from './Header'
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';
import '../styles/App.css';
import PlannerPage from './PlannerPage';
import HomePage from './HomePage'
import RegisterPage from "./Register";
import LoginPage from "./LoginPage";

const App = () => (
  <div className="App">
    <Router>
      <Header />
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">HomePage</Link>
            </li>
            <li>
              <Link to="/planner">PlannerPage</Link>
            </li>
            <li>
              <Link to="/login">LoginPage</Link>
            </li>
            <li>
              <Link to="/register">Register</Link>
            </li>
          </ul>
        </nav>
        <Switch>
          <Route path="/planner">
            <PlannerPage />
          </Route>
          <Route path="/register">
            <RegisterPage />
          </Route>
          <Route path="/login">
            <LoginPage />
          </Route>
          <Route path="/">
            <HomePage />
          </Route>
        </Switch>
      </div>
    </Router>
  </div>
);

export default App;