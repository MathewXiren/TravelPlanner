import React, { Component } from "react";
import Login from './Login';
import Register from './Register';

export default class HomePage extends Component {
  constructor() {
    super();
    this.state = {
      loggedIn: false
    }
  }

  signinOnSuccess = () => {
    // getFavoriteItem().then((data) => {
    //   this.setState({
    //     loggedIn: true
    //   })
    // }).catch((err) => {
    //   message.error(err.message);
    // })
    console.log("login success")
  }
  // signoutOnClick = () => {
  //   logout()
  //       .then(() => {
  //         this.setState({
  //           loggedIn: false
  //         })
  //         message.success(`Successfull signed out`);
  //       }).catch((err) => {
  //     message.error(err.message);
  //   })
  // }

  render() {
    return (
        <div>
          <h1>HomePage</h1>
          {/*<div>*/}
          {/*  /!*<Login onSuccess={this.signinOnSuccess}/>*!/*/}
          {/*  /!*<Register/>*!/*/}
          {/*</div>*/}
        </div>
    )
  }
}