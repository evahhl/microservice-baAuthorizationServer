import React, { Component } from 'react';
import AppNavbar from '../app-navbar';
import { Table, Navbar, Button,  Col, CardTitle, Container } from 'reactstrap';
import { NavbarText, NavLink, Row } from 'reactstrap';
import { Alert } from "react-bootstrap"
import Profile from '../profile';
import Footer from '../footer';
import { BsPersonPlusFill } from "react-icons/bs";
import { BsTrash } from "react-icons/bs";
import { BiEditAlt } from "react-icons/bi";
import { withTranslation } from 'react-i18next';
import BackendService from '../../services/backend-service';
import AuthenticationService from '../../services/authentication-service';

class UsersList extends Component {

  constructor(props) {
    super(props);
    this.state = {
      user: undefined,
      content: "",
      error: "",
      showUser: false,
      showPM: false,
      showAdmin: false,
      username: undefined,
      login: false};
  }

  componentDidMount() {    
    const user = AuthenticationService.getCurrentUser();
    var roles=user?user.userInfo.userTypeDescription:"";

     // login
     if (user) {   
      if (roles.includes("Auxiliar") || roles.includes("Admin")){
          BackendService.getUsers().then(content => {
            this.setState({content: content});
            }
          );
      }
    }
    
    this.setState({user: user});
    this.setState({
      showUser: false,
      showPM: roles.includes("Auxiliar") || 
              roles.includes("Admin"),
      showAdmin: roles.includes("Admin")});
  }

  

  render() {
    const { t } = this.props;
    let usersInfo = "";
    const user = this.state.user;
    var content = this.state.content?this.state.content:[];

     if (this.state.showAdmin || this.state.showPM) {   

      usersInfo = (                             
                <Container className="userinfo">
                  <Navbar className="justify-content-between">
                    <NavLink href="/user" className="gray">{t('userPage.home')}</NavLink>
                    <NavbarText>
                      <strong>{t('userPage.Signed')}</strong> 
                      <NavLink href="/user" className="gray">{user.userInfo.email}</NavLink>
                    </NavbarText>
                  </Navbar>                   
                    <Row>   
                      <Profile/>   
                      <Col className="content">
                        <Container className="activity">
                        <CardTitle tag="h5"><strong><br/>{t('menu.users')}</strong> 
                        <Button color="link">
                             <BsPersonPlusFill/> 
                        </Button>
                        </CardTitle>
                        <Table>
                            <thead>
                                <tr>
                                <th>#</th>
                                <th>{t('users.firstName')}</th>
                                <th>{t('users.LastName')}</th>
                                <th>{t('users.email')}</th>
                                <th>{t('users.phoneNumber')}</th>
                                <th>{t('users.mobileNumber')}</th>
                                <th>{t('users.aparment')}</th>
                                <th>{t('users.type')}</th>
                                <th>{t('users.actions')}</th>
                                </tr>
                            </thead>
                            <tbody>
                            {content.map( item => (
                                <tr>
                                    <th scope="row">{item.userId}</th>
                                    <td>{item.name}</td>
                                    <td>{item.lastName}</td>
                                    <td>{item.email}</td>
                                    <td>{item.phoneNumber}</td>
                                    <td>{item.mobileNumber}</td>
                                    <td>{item.mobileNumber}</td>
                                    <td>{item.userTypeId.userTypeDescription}</td>
                                    <td><Button color="link" onClick={() => this.onEdit()}><BiEditAlt/></Button>
                                        <Button color="danger" outline onClick={() => this.onDelete()}><BsTrash/> </Button>
                                    </td>
                                </tr>
                                ))
                            }
                            </tbody>
                        </Table>
                        </Container>
                      </Col>    
                     </Row> 
                </Container>             
              );
    } else { // not login
      usersInfo = <div style={{marginTop:"20px"}} className="text-center" >
                    <Alert variant="secondary">
                      <h2>{t('unauthorized')}</h2>
                      <Button color="primary"  href="/user">{t('button.return')}                        
                      </Button>
                    </Alert>
                  </div>
    }

    return (
      <div>
        <AppNavbar/>
        {usersInfo}
        <Footer/>
      </div>
    );
  }

  onEdit() {
    this.props.onEdit();
  }
  onDelete() {
    const item = this.props.item;
    if(window.confirm("Are you sure to delete item: " + item.name + " ?")) {
      this.props.onDelete(item.link);
    }
  }  

  onCreateItem(newItem) {
    this.clearState();
    this.BackendService.createUser(newItem).then(item => {
        this.getItems();
      }
    );
  }
}

export default withTranslation()(UsersList);