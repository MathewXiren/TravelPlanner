import React, { Component } from "react";
import Login from './Login';

export default class LoginPage extends Component {
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
                <Login onSuccess={this.signinOnSuccess}/>
            </div>
        )
    }
}