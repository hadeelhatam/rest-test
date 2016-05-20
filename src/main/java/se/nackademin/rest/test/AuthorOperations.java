/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
//import static groovy.xml.dom.DOMCategory.name;
import java.util.Random;
import java.util.UUID;
//import static org.apache.http.client.methods.RequestBuilder.delete;


public class AuthorOperations {
    private static final String BASE_URL ="http://localhost:8080/librarytest/rest/";    
    private String jsonString = "";
    private Integer id; 
    private String name; 

    public Response getAuthor(int id) {
        String resourceName = "authors" +id;
        Response response = given().accept(ContentType.JSON).get(BASE_URL + resourceName);
        return response;
    }
    public Integer getId() { 
        return id; 
    } 
    public String prepareNewAuthorSpec() { 
        setId((Integer) new Random().nextInt(7000)); 
        name = UUID.randomUUID().toString(); 
        String postBodyTemplate = ""+ 
                 "\"author\":\n" + 
                 "  {\n" + 
                 "    \"name\":\"%s\",\n" + 
                 "    \"id\":%s\n" + 
                 "  }"; 
        String postBody = String.format(postBodyTemplate, name, ""+id); 
        return postBody;         
  } 

    
    public Response createRandomAuthor(){
        String resourceName = "authors";
        String name1 = UUID.randomUUID().toString();
        String postBodyTemplate =""
                +"  {\n"
                +"  \"author\":\n"
                +"  {\n"
                +"  \"name\":\"%s\",\n"
                +"  }\n"
                +"  }";
        String postBody; 
        postBody = String.format(postBodyTemplate, name1, "" +new Random());
        jsonString = postBody;
        Response postResponse = given() .contentType(ContentType.JSON) .body(postBody) .post(BASE_URL + resourceName);
        return postResponse;    
}
    public String getLatestJsonString(){
        return jsonString;
    }
    public Response getAllAuthors(){
        String resourceName = "authors";
        Response getResponse = given() .accept(ContentType.JSON) .get(BASE_URL + resourceName).prettyPeek();
        return getResponse;    
    }
  
    public Response deleteAuthor(int id){
        String deleteResourceName = "authors/"+ id;
        Response deleteResponse =  given().delete(BASE_URL + deleteResourceName);
        return deleteResponse;  
    }
    public String getName() { 
        return name; 
    } 
 public void setName(String name) { 
        this.name = name; 
    } 
   
public Response createNewAuthorTemplate(String nameTemplate, Integer idTemplate) {  
        String resourseName="authors";  
        String postBodyTemplate = ""+"{\n" +  
                 "\"author\":\n" +  
                "  {\n" +  
                 "    \"name\":\"%s\",\n" +  
                 "    \"id\":%s\n" +  
                 "  }\n" +  
               "}";  
          
        String postBody = String.format(postBodyTemplate, nameTemplate, ""+idTemplate);  
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName).prettyPeek();   
        System.out.println("Status code: " + postResponse.getStatusCode());  
        return postResponse;          
   
    }  

 
public Response createNewAuthor() {  
        String resourseName="authors";  
        String postBody = prepareNewAuthorRandom();  
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName).prettyPeek();  
        System.out.println("Status code: " + postResponse.getStatusCode());  
        return postResponse;          
  
     }  
 public String prepareNewAuthorRandom() {  
        //String resourseName="authors";  
        name = UUID.randomUUID().toString();  
        setId((Integer) new Random().nextInt(6000));  
        String postBodyTemplate = ""+"{\n" +  
                "\"author\":\n" +  
                "  {\n" +  
                "    \"name\":\"%s\",\n" +  
                "    \"id\":%s\n" +  
                "  }\n" +  
                "}";  
          
        String postBody = String.format(postBodyTemplate, name, ""+id);  
        return postBody;          
    }  

    public void setId(Integer id) { 
       this.id = id; 
    } 

    public Response addbooksBookidAuthors (Integer bookId) { 
         //books/{book_id}/authors 
         String resourseName="authors"; 
         String resourseName1="books/"; 
         name = UUID.randomUUID().toString(); 
         setId((Integer) new Random().nextInt(5000)); 
 
 
         String postBodyTemplate = ""+"{\n" + 
                 "\"author\":\n" + 
                 "  {\n" + 
                 "    \"name\":\"%s\",\n" + 
                 "    \"id\":%s\n" + 
                 "  }\n" + 
                 "}"; 
         
        String postBody = String.format(postBodyTemplate, name, ""+id); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
                
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
    public Response addAdditionalAuthorAlreadyUsedToBookN(Integer bookId) { 
        String resourseName="authors"; 
        String resourseName1="books/"; 
        name = UUID.randomUUID().toString(); 
        setId((Integer) new Random().nextInt(5000)); 
        String postBodyTemplate = ""+"{\n" + 
                "\"author\":\n" + 
                "  {\n" + 
                "    \"name\":\"%s\",\n" + 
                "    \"id\":%s\n" + 
                "  }\n" + 
                "}"; 
          
        String postBody = String.format(postBodyTemplate, name, ""+id); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
                  
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
          
        postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
    } 
    
    public String addbooksBookidAuthors() {//add Additional Author Without Id Template 
        //books/{book_id}/authors 
        String resourseName="authors"; 
         name = UUID.randomUUID().toString(); 
        String postBodyTemplate = ""+"{\n" + 
                 "\"author\":\n" + 
                 "  {\n" + 
                 "    \"name\":\"%s\"\n" + 
                 "  }\n" + 
                 "}"; 
        String postBody = String.format(postBodyTemplate, name); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postBody;        
    }

 public Response addAdditionalAuthorWithoutIdToBookN(Integer bookId) { 
        //books/{book_id}/authors 
        String resourseName1="books/"; 
        String postBody = addbooksBookidAuthors (); 
        Response postResponse = given().contentType(ContentType.JSON).body(postBody).post(BASE_URL + resourseName1 + bookId +"/authors"); 
        System.out.println("Status code: " + postResponse.getStatusCode()); 
        return postResponse;         
   } 
}
