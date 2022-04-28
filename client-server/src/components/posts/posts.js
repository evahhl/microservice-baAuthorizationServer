import React, { Component } from 'react';
import { Col } from 'reactstrap';
import AuthenticationService from '../../services/authentication-service';
import NewPost from './new-post';
import PostsList from './posts-list';

class Posts extends Component {

  constructor(props) {
    super(props);
    this.state = {
      showUser: false,
      showPM: false,
      showAdmin: false};
  }

  componentDidMount() {
    const user = AuthenticationService.getCurrentUser();     
    const roles = user.userInfo.userTypeDescription?user.userInfo.userTypeDescription: "";
    
    this.setState({user: user});    
    this.setState({roles: roles});  
    this.setState({
      showUser: true,
      showPM: roles.includes("Auxiliar") || roles.includes("Admin"),
      showAdmin: roles.includes("Admin")});
    
  }

  render() {
    const newPost = this.state.showAdmin;
    return (
        <Col className="content">
             {newPost?<NewPost/>:""}
             <PostsList/>  
        </Col>           
    ); 
  }  
}

export default Posts;