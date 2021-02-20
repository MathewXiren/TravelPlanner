import React, { Component } from "react";
import Register from './Register';

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
                <Register/>
            </div>
        )
    }
}