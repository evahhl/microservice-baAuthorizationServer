import React, { Component } from 'react';
import {Container, Row,Col, Button, CardTitle, Nav, Navbar, NavItem, NavLink,UncontrolledDropdown,DropdownToggle, DropdownMenu, DropdownItem  } from 'reactstrap';
import { withTranslation } from 'react-i18next';
import { withRouter } from 'react-router-dom';
import AuthenticationService from '../services/authentication-service';

class AppNavbar extends Component {
  constructor(props) {
    super(props);
    this.state = {isOpen: false};
    this.toggle = this.toggle.bind(this);

    this.state = {
      showUser: false,
      showPM: false,
      showAdmin: false,
      login:false
    };
  }

  componentDidMount() {
    const user = AuthenticationService.getCurrentUser();
    const roles = user?user.userInfo.userTypeDescription: "";

    if (user) {
      this.setState({
        showOwn: roles.includes("Dueño"),
        showUser: roles.includes("Residente") || roles.includes("Inquilino"),
        showPM: roles.includes("Auxiliar") || roles.includes("Admin"),
        showAdmin: roles.includes("Admin"),
        login:true
      });
    }
  }

  signOut = () => {
    AuthenticationService.signOut();
    this.props.history.push('/');
    window.location.reload();
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  render() {
    const { t } = this.props;

    const onChangeLanguage =  () => {
      const { i18n} = this.props;

      if(i18n.language==='en'){
        i18n.changeLanguage('es');        
      }else{
        i18n.changeLanguage('en');
      }
      withTranslation()(AppNavbar);
    }

      return (
        <Navbar className=" white"  color="dark" dark>        
          <Nav className=" white" style={{ width: "100%" }}> 
            <Container>
              <Row>
                <Col sm={8}><NavLink href="/user" className="white"><CardTitle tag="h4">{t('buildingAdmin')}</CardTitle></NavLink></Col>
                <Col sm={4} className="text-left">
                  <Nav className="text-left">
                  { this.state.showOwn && 
                     <NavItem>              
                        <NavLink href="/perfil" className="white">{t('menu.perfil')}</NavLink>
                     </NavItem>
                  }    
                  { this.state.login &&              
                    <NavItem>              
                      <NavLink href="/requests" className="white">{t('menu.serviceRequests')}</NavLink>
                    </NavItem>
                  }
                  { this.state.showAdmin &&                   
                    <NavItem>     
                      <UncontrolledDropdown setActiveFromChild>
                        <DropdownToggle tag="a" className="nav-link white" caret>
                        {t('menu.administration')}
                        </DropdownToggle>
                        <DropdownMenu>
                          <DropdownItem tag="a" href="/usersList">{t('menu.users')}</DropdownItem>                       
                          <DropdownItem tag="a" href="/buildings">{t('menu.buildings')}</DropdownItem>                       
                          <DropdownItem tag="a" href="/balance">{t('menu.balance')}</DropdownItem>
                        </DropdownMenu>
                      </UncontrolledDropdown>
                    </NavItem> 
                  }
                  { this.state.login &&
                  <NavItem>              
                    <NavLink href="#" onClick={this.signOut} className="white">{t('menu.logout')}</NavLink>
                  </NavItem>
                  }
                   <Button color="link" onClick={onChangeLanguage}>
                    {t('language')}
                    </Button>
                  </Nav>
                </Col>
              </Row>
            </Container>
          </Nav> 
        </Navbar>  
      );
  }
}

export default withTranslation()(withRouter(AppNavbar));