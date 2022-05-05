import React, { Component } from 'react';
import { Navigate} from 'react-router';
import { withTranslation } from 'react-i18next';
import { Navbar,  NavbarText, NavLink, Container, Row} from 'reactstrap';
import AppNavbar from './app-navbar';
import ProfileInfo from './profile';
import PostsInfo from './posts/posts';
import Balance from './balance';
import Footer from './footer';
import AuthenticationService from '../services/authentication-service';

class UserPage extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      user: undefined,
      content: "",
      error: "",
      login: false};
  }

  renderRedirect = () => {
    if (!AuthenticationService.getCurrentUser()) {
      return <Navigate to='/' />
    }
  }

  componentDidMount() {    
    const user = AuthenticationService.getCurrentUser();  
    const roles = user?user.userInfo.userTypeDescription: "";
    this.setState({user: user});
    this.setState({
      showUser: true,
      showPM: roles.includes("Auxiliar") || roles.includes("Admin"),
      showAdmin: roles.includes("Admin")});
    
  }

  render() {
    let userInfo = "";
    const user = this.state.user;
    const { t } = this.props;    
    

    // login
    if (user && user.token) {   

      userInfo = (                             
                <Container className="userinfo">
                  <Navbar className="justify-content-between">
                    <NavLink href="/user" className="gray"> {t('userPage.home')}</NavLink>
                    <NavbarText>
                      <strong>{t('userPage.Signed')}</strong> 
                      <NavLink href="/user" className="gray">{user.userInfo.email}</NavLink>
                    </NavbarText>
                  </Navbar>                   
                    <Row>   
                      <ProfileInfo/>
                      <PostsInfo/>
                      <Balance/>       
                     </Row> 
                </Container>             
              );
    } 

    return (
      <div>
        <AppNavbar/>
        {this.state.user && userInfo}
        {!this.state.user && this.renderRedirect()}
        <Footer/>
      </div>
    );
  }
}

export default withTranslation()(UserPage);