import axios from 'axios';
import Configuration from './configuration';
import EventBus from "../components/eventBus";

// Add a request interceptor
axios.interceptors.request.use( config => {
  const user = JSON.parse(localStorage.getItem('user'));

  if(user && user.token){
    config.headers.Authorization =  user.token;
  }

  return config;
});

class BackendService {

  constructor() {
    this.config = new Configuration();
  }
  
  getUserBoard = (email) => {
    return axios.get(this.config.USER_INFO_BY_EMAIL+email, {
      headers: {
        "Content-Type": "application/json"
      }
    }).then( response => {
      const item = response.data;
      return item;  
    } , error => {
      console.log("getUserBoard: " + error);
      localStorage.setItem("error", error.toString());   
      if (error.response && error.response.status === 401) {
        EventBus.dispatch("logout");
      } 
    });
  }

  getUsers = () => {
    return axios.get(this.config.USER_LIST, {
      headers: {
        "Content-Type": "application/json"
      }
    }).then( response => {
      const items = [];
    
      for(var i = 0; i < response.data.length; i++) {  
        items.push(response.data[i]);
      }
      localStorage.setItem("usersList", items);
      return items;  
    } , error => {
      console.log("getUsers: " + error);
      localStorage.setItem("error", error.toString());   
      if (error.response && error.response.status === 401) {
        EventBus.dispatch("logout");
      } 
    });    
  }

  getUserList() {
    return localStorage.getItem('usersList');
  }

  getError() {
    return localStorage.getItem('error');
  } 
  
}
export default new BackendService();