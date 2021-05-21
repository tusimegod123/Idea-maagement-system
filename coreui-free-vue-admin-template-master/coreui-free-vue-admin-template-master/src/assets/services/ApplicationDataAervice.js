import http from "../axiosInitializer";

class ApplicationDataService {
     getAllIdeas() { 
       return http.get("/ideas");
      }

}

export default  ApplicationDataService();