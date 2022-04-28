import Configuration from './configuration';

class ZipCodesItemService {
    
  constructor() {
    this.config = new Configuration();
  }
  
  async retrieveItems() {
    console.log('ZipCodesItemService.retrieveItems():');
    const token = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJldmFoaGxAaG90bWFpbC5jb20iLCJleHAiOjE2MjkzMjk3ODgsImlhdCI6MTYyOTMxMTc4OH0.IHBkAhfuuqwkpvIgB0gzv2ymYvEEkz7B02xJBXEq6slTKgtkBYZNgJOUiZp0eMLE9m-1Lq5s_hvkq1lyybe8CQ';
    return fetch(this.config.ZIP_CODES_COLLECTION_URL, {
      method: 'GET',
      mode: 'cors',
      headers: new Headers({
            'Content-Type': 'application/json',
            'Authorization': token
        })
      })
      .then(response => {
        if (!response.ok) {
          this.handleResponseError(response);
        }
        return response.json();
      })
      .then(json => {
        console.log('Retrieved items:');
        console.log(json);
        const items = [];
       
        for(var i = 0; i < json.length; i++) {
          items.push(json[i]);
        }
        return items;
      })
      .catch(error => {
        this.handleError(error);
      });
  }
  
  async getItem(itemLink) {
    console.log("ZipCodesItemService.getItem():");
    console.log("Item: " + itemLink);
    return fetch(itemLink)
      .then(response => {
        if (!response.ok) {
            this.handleResponseError(response);
        }
        return response.json();
      })
      .then(item => {
          item["link"] = item._links.self.href;
          return item;
        }
      )
      .catch(error => {
        this.handleError(error);
      });
  }
  
  async createItem(newitem) {
    console.log("ZipCodesItemService.createItem():");
    console.log(newitem);
    /*return fetch(this.config.ITEM_COLLECTION_URL, {
      method: "POST",
      mode: "cors",
      headers: {
            "Content-Type": "application/json"
        },
      body: JSON.stringify(newitem)
    })
      .then(response => {
       if (!response.ok) {
            this.handleResponseError(response);
        }
        return response.json();
      })
      .catch(error => {
        this.handleError(error);
      });*/
  }
  
  async deleteItem(itemlink) {
    console.log("ZipCodesItemService.deleteItem():");
    console.log("item: " + itemlink);
  /* return fetch(itemlink, {
      method: "DELETE",
      mode: "cors"
    })
      .then(response => {
        if (!response.ok) {
            this.handleResponseError(response);
        }
      })
      .catch(error => {
        this.handleError(error);
      });*/
  }
  
  async updateItem(item) {
    console.log("ZipCodesItemService.updateItem():");
    console.log(item);
    /*return fetch(item.link, {
      method: "PUT",
      mode: "cors",
      headers: {
            "Content-Type": "application/json"
          },
      body: JSON.stringify(item)
    })
      .then(response => {
        if (!response.ok) {
          this.handleResponseError(response);
        }
        return response.json();
      })
      .catch(error => {
        this.handleError(error);
      });*/
  }
  
  handleResponseError(response) {
      throw new Error("HTTP error, status = " + response.status);
  }
  
  handleError(error) {
      console.log(error.message);
  }
  
}

export default ZipCodesItemService;
