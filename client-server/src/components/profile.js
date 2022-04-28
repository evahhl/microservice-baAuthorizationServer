import React, { Component } from 'react';
import { List, } from 'reactstrap';
import { CardImg, CardTitle, Col } from 'reactstrap';
import AuthenticationService from '../services/authentication-service';
import avatar from '../images/avatar.png';
import { withRouter } from 'react-router-dom';

class Profile extends Component {

  constructor(props) {
    super(props);
    this.state = {
      user: undefined,
      userInfo: "",
      error: "",
      showUser: false,
      showPM: false,
      showAdmin: false,
      login: false};
  }

  componentDidMount() {
    const user = AuthenticationService.getCurrentUser();
    const userInfo =  user.userInfo;
    const roles = AuthenticationService.getCurrentAuthorities();
    
    this.setState({user: user, userInfo: userInfo, roles: roles});
    this.setState({
      showUser: true,
      showPM: roles.includes("Auxiliar") || roles.includes("Admin"),
      showAdmin: roles.includes("Admin")});
    
  }

  render() {
    const userInfo =  this.state.userInfo;

    return (
      <Col className="content leftrigthprofile d-none d-lg-block">
        <CardImg  src = {avatar}  alt="building" />
        <CardTitle tag="h5">&nbsp;</CardTitle>
        <div className="text-center">
          <List type="unstyled">                     
            <li><CardTitle tag="h5">{userInfo.name} </CardTitle></li>
            <li><CardTitle tag="h5">{userInfo.lastName}</CardTitle></li>
            <li>{userInfo.buildingName}</li>
            <li>{userInfo.apartmentNumber}</li>
            <li>{userInfo.email}</li>
            <li>{userInfo.phoneNumber}</li>
            <li>{userInfo.mobilePhone}</li>
            <li>{userInfo.userTypeDescription}</li>
          </List>
        </div>           
      </Col>
    );
  }
}

export default withRouter(Profile);