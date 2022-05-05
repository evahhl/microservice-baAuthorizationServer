class Configuration {

    SECURITY_SERVER = "http://localhost:8083/auth/realms/nartan-ba";
    ADMIN_SERVER = "http://localhost:8081/";
    POST_SERVER = "http://localhost:2223/v1/post/";

    //LOGIN
    AUTHENTICATE_URL = this.SECURITY_SERVER + "authenticate";

    //USER
    USER_FIND_BY_EMAIL = this.ADMIN_SERVER + "user/findbyEmail/";
    USER_INFO_BY_EMAIL = this.ADMIN_SERVER + "user/findUserInfo/";
    USER_ADD = this.ADMIN_SERVER + "user/addLogin";
    USER_LIST = this.ADMIN_SERVER + "user/all";

    //ZIP CODES
    ZIP_CODES_LIST = this.ADMIN_SERVER + "zipCode/showZipCodes";
    ZIP_CODES_ADD = this.ADMIN_SERVER + "zipCode/add";
    ZIP_CODES_FIND_BY_STATUS = this.ADMIN_SERVER + "zipCode/findbyStatus/";

    //POST
    POST_LIST = this.POST_SERVER + "all";
    POST_LIST_ACTIVE= this.POST_SERVER + "all/active";
    POST_ADD = this.POST_SERVER + "add";
    POST_DELETE = this.POST_SERVER + "delete/";

}

export default Configuration;