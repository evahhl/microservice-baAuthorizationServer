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

class PostService {

  constructor() {
    this.config = new Configuration();
  } 
  
  getPosts(page, size, sortBy) {
    const params = {
      page: page,
      size: size,
      sortBy: sortBy
    };

    return axios.get(this.config.POST_LIST_ACTIVE, {
      headers: {
                  "Content-Type": "application/json"
                }, 
      params  
    }).then(response => {      
      const items = [];
      const itemArray = response.data.results;
    
      for(var i = 0; i < itemArray.length; i++) {   
        const commentsArray = [];        
        var data = itemArray[i];
        var comments = itemArray[i].comments;

        if(comments){   
          for(var a = 0; a < comments.length; a++) {   
            commentsArray.push(comments[a]); 
          }          
        }
        data.comments = commentsArray;

        items.push(data);
      }
      localStorage.setItem("totalPages", response.data.totalPages);

      return items; 

      } , error => {
        console.log("getPosts: " + error);
        localStorage.setItem("error", error.toString());   
        if (error.response && error.response.status === 401) {
          EventBus.dispatch("logout");
        } 
    });
  } 

  async createPost(newitem) {
    return axios.post(this.config.POST_ADD, newitem, {
      headers: {
            "Content-Type": "application/json"
        },
    })
      .then(response => {
        console.log("createPost: " + response.data);
        return true;
      })
      .catch(error => {
        throw error;
      });
  }

  async editPost(idPost, editItem) {
    return axios.post(this.config.POST_SERVER+idPost+"/edit", editItem, {
      headers: {
            "Content-Type": "application/json"
        },
    })
      .then(response => {
        return true;
      })
      .catch(error => {
        localStorage.setItem("error", error.toString()); 
        console.log("editPost "+ error.toString());
        return false;          
      });
  }

  async deletePost(idPost) {
    return axios.delete(this.config.POST_DELETE+idPost, {
      headers: {
            "Content-Type": "application/json"
        },
      }).then(() => {
        console.log("deletePost success " + idPost);
        return true;
      })
      .catch(error => {
        localStorage.setItem("error", error.toString()); 
        console.log("deletePost error"+ error.toString());
        throw error;    
      });
  }

  async likePost(idPost) {
    return axios.post(this.config.POST_SERVER+idPost+"/like", {
      headers: {
            "Content-Type": "application/json"
        },
    })
      .then(response => {
        return true;
      })
      .catch(error => {
        throw error;
      });
  }

  async unlikePost(idPost) {
    return axios.post(this.config.POST_SERVER+idPost+"/unlike", {
      headers: {
            "Content-Type": "application/json"
        },
    })
      .then(response => {
        return true;
      })
      .catch(error => {
        throw error;
      });
  }

  async addComment(idPost,comment) {
    return axios.post(this.config.POST_SERVER+idPost+"/comment/add", comment, {
      headers: {
            "Content-Type": "application/json"
        },
    })
      .then(response => {
        return true;
      })
      .catch(error => {
        throw error;
      });
  }

  async likeComment(idPost,idComment) {
    return axios.post(this.config.POST_SERVER+idPost+"comment/"+idComment+"/like", {
      headers: {
            "Content-Type": "application/json"
        },
    })
      .then(response => {
        return true;
      })
      .catch(error => {
        throw error;
      });
  }

  async deleteComment(idPost,idComment) {
    return axios.delete(this.config.POST_DELETE+idPost+"/"+idComment, {
      headers: {
            "Content-Type": "application/json"
        },
      }).then(() => {
        console.log("deleteComment success " + idPost);
        return true;
      })
      .catch(error => {
        localStorage.setItem("error", error.toString()); 
        console.log("deleteComment error"+ error.toString());
        throw error;    
      });
  }


  getError() {
    return localStorage.getItem('error');
  } 

  getTotalPages() {
    return localStorage.getItem('totalPages');
  } 
  
}
export default new PostService();