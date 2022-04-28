import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import UserPage from './components/user-page';
import UsersList from './components/users/users-list';
import SignUp from './components/sign-up';
import Login from './components/login';
import AuthVerify from "./components/auth-verify";
import EventBus from "./components/eventBus";
import AuthenticationService from './services/authentication-service';

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);


    this.state = {
      username: undefined,
    };
  }

  componentDidMount() {
    const user =AuthenticationService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
      });
    }
    
    EventBus.on("logout", () => {
      this.logOut();
    });
  }

  componentWillUnmount() {
    EventBus.remove("logout");
  }

  logOut() {
    AuthenticationService.signOut();
    this.setState({
      username: undefined,
    });
  }

  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact component={Login}/>
          <Route path='/user' exact component={UserPage}/>
          <Route path='/usersList' exact component={UsersList}/>
          <Route path='/signin' exact={true} component={Login}/>
          <Route path='/signup' exact={true} component={SignUp}/>  
        </Switch>
        <AuthVerify logOut={this.logOut}/>
      </Router>
    )
  }
}

export default App;