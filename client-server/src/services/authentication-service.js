import axios from "axios";
import Configuration from './configuration';

class AuthenticationService {
  constructor() {
    this.config = new Configuration();
  }

  signin = (username, password) => {
      console.log('AuthenticationService');
      return axios.post(this.config.AUTHENTICATE_URL, {username, password})
        .then(response => {
          if (response.data) {            
            localStorage.setItem("user", JSON.stringify(response.data));
          }
          return response.data;
        })        
        .catch(err => {
          console.log(err);
          throw err;
        });
  }

  signOut() {
      localStorage.removeItem("user");
      localStorage.removeItem("error");
  }

  register = async(firstname, lastname, username, email, password) => {
    return axios.post(this.USER_ADD, {
      firstname,
      lastname,
      username,
      email,
      password
    });
  }

  userByEmail = (email,token) => {
    console.log('userByEmail');
    return axios.get(this.config.USER_FIND_BY_EMAIL+email, {
      headers: {
        "Content-Type": "application/json",
        authorization: token
      }
    }) 
    .then(response => {
      if (response.data) {            
        localStorage.setItem("user", JSON.stringify(response.data));
      }
      return response.data;
    })      
    .catch(err => {
      console.log(err);
      throw err;
    });
  }

  getCurrentUser() {
    var user = JSON.parse(localStorage.getItem("user"));
    console.log(user)
    if (user) {
      const decodedJwt = this.parseJwt(user.token);

      if (decodedJwt.exp * 1000 < Date.now()) {
        this.signOut();
      }
    }

    return user;
  }

  getCurrentAuthorities() {
    localStorage.setItem("authorities", "Admin");
    return localStorage.getItem('authorities');
  }

  parseJwt = token => {
      try {
        const base64Url = token.split('.')[1];
        const base64 = base64Url.replace('-', '+').replace('_', '/');
        return JSON.parse(window.atob(base64));
      } catch (error) {
        console.log('parseJwt: '+error);
        return null;
      }    
  };  
}

export default new AuthenticationService();