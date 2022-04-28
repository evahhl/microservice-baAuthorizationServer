import $ from 'jquery';

class Validator {
    validateInputs(inputData) {
      let errorMsg = "";
      if(!inputData.name) {
        errorMsg +="Please enter name of this item.\n"
      }
      if(!inputData.summary) {
        errorMsg +="Please enter summary of this item.\n"
      }
      if(inputData.year.toString().match(/[^0-9]/g)) {
        errorMsg +="Year must be a number.\n"
      }
      if(inputData.country.length > 0 && !inputData.country.match(/^[a-z|A-Z][a-z|A-Z]$/)) {
        errorMsg +="Country code must be two letters.\n"
      }
      if(errorMsg.length === 0){
        return true;
      } else {
        alert(errorMsg);
        return false;
      }
    }

    validatePost(inputData) {
      let errorMsg = "";
      if(!inputData.inpTitle) {
        errorMsg +="Please enter title of this post.\n"
      }
      if(!inputData.txtDescription) {
        errorMsg +="Please enter description of this post.\n"
      }
      if(errorMsg.length === 0){
        return true;
      } else {
        alert(errorMsg);
        return false;
      }
    }

    validatePostEdit(idPost) {
      const inpTitle= '#inpTitle' + idPost;
      const txtDescription=  '#txtDescription' + idPost;    
      let errorMsg = "";
      if(!$(inpTitle).val()) {
        $(inpTitle).addClass("borderError");
        $('#errorTitle'+idPost).show();
        errorMsg +="error"        
      }
      if(!$(txtDescription).val()) {
        $(txtDescription).addClass("borderError");
        $('#errorDescription'+idPost).show();
        errorMsg +="error"       
      }
      if(errorMsg.length === 0){
        $(inpTitle).removeClass("borderError");
        $(txtDescription).removeClass("borderError");
        $('#errorTitle'+idPost).hide();
        $('#errorDescription'+idPost).hide();
        return true;
      } else {
        return false;
      }
    }

    validateComment(idPost) {
      const txtComment= '#txtComment' + idPost;
      let errorMsg = "";
      if(!$(txtComment).val()) {
        $(txtComment).addClass("borderError");
        $('#errorComment'+idPost).show();
        errorMsg +="error"        
      }
      if(errorMsg.length === 0){
        $(txtComment).removeClass("borderError");
        $('#errorComment'+idPost).hide();
        return true;
      } else {
        return false;
      }
    }
  }
    export default Validator;
    