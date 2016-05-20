/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import java.util.Random;
import java.util.UUID;
import static org.apache.http.client.methods.RequestBuilder.delete;

public class BookOperations {
    private static final String BASE_URL ="http://localhost:8080/librarytest/rest/";    
    private String jsonString = "";
    private Integer nbOfPage; 
    private Integer id; 
    private String description; 
    private String isbn; 
    private String title; 
    
    public Response getBook(int id) {
        String resourceName = "books" +id;
        Response response = given().accept(ContentType.JSON).get(BASE_URL + resourceName);
        return response;
    }
  
    public Integer getId() { 
         return id; 
     } 
 
 
    public Response get(int id) { 
        String resourseName="books/"+id; 
        Response getResponse = given().accept(ContentType.JSON).get(BASE_URL+resourseName); 
        System.out.println("Status code: " + getResponse.getStatusCode()); 
        return getResponse;                
    } 
    public Response getBooksbookidAuthors(Integer bookId) { 
        ///books/{book_id}/authors 
        String resourceName = "books/"+bookId; 
        Response response = given().accept(ContentType.JSON).get(BASE_URL+resourceName+"/authors").prettyPeek(); 
        return response; 
    }
    public Response getBooksAuthor(Integer authorId) { 
        ///books/byauthor/{author_id} 
        String resourceName = "books/byauthor/"+authorId; 
        Response response = given().accept(ContentType.JSON).get(BASE_URL+resourceName).prettyPeek(); 
        return response; 
    } 


    public Response createRandomBook(){
        String resourceName = "books";
        String title = UUID.randomUUID().toString();
        String description = UUID.randomUUID().toString();
        String isbn = UUID.randomUUID().toString();
               
        String postBodyTemplate =""
                +"  {\n"
                +"\"book\":\n"
                +"  {\n"
                +"\"description\":\"%s\",\n"
                +"\"isbn\":\"%s\",\n"
                +"\"nbofPage\"%s,\n" 
                +"\"title\":\"%s\",\n"
                +"  }\n"
                +"  }";
    
        String postBody = String.format(postBodyTemplate, description, isbn, "" +new Random().nextInt(500), title); 
        jsonString = postBody;
        Response postResponse = given() .contentType(ContentType.JSON) .body(postBody) .post(BASE_URL + resourceName);
        return postResponse;    
}
   
public String createRandomBookTemplate(String templateAuthor) {  
        title = UUID.randomUUID().toString();  
        description = UUID.randomUUID().toString();  
        isbn = UUID.randomUUID().toString();  
        nbOfPage = new Random().nextInt(600);  
        id = new Random().nextInt(6000);  
 
         String postBodyTemplate = ""+"{\n" +  
                "    \"book\":\n" +  
                "    {\n" +  
                "    \"description\":\"%s\",\n" +  
                "    \"isbn\":\"%s\",\n" +  
                "    \"nbOfPage\":%s,\n" +  
                "    \"title\":\"%s\",\n" +  
                "    \"id\":%s\n" +  
                "    "+templateAuthor+  
                "    }\n" +  
                "    }";  
       String postBody = String.format(postBodyTemplate, description, isbn, ""+nbOfPage, title, ""+getId());  
       return postBody;   
    }  

  public Response createBook(String bookTemplate) {  
       String resourseName="books";  
       Response postResponse = given().contentType(ContentType.JSON).body(bookTemplate).post(BASE_URL + resourseName);  
       System.out.println("Status code: " + postResponse.getStatusCode());  
       return postResponse;          
    }  

/* public Response put(String booksTemplate) {  
        String resourseName="books";  
        Response putResponse = given().contentType(ContentType.JSON).body(booksTemplate).put(BASE_URL + resourseName);  
        System.out.println("Status code: " + putResponse.getStatusCode());  
        return putResponse;              
    }  
  */ 
    public String getLatestJsonString(){
        return jsonString;
    }
    public Response getAllBooks(){
    String resourceName = "books";
    Response getResponse = given() .accept(ContentType.JSON) .get(BASE_URL + resourceName).prettyPeek();
    return getResponse;    
    }
  
    public Response deleteBook(int id){
    String deleteResourceName = "books/"+ id;
    Response deleteResponse =  given().delete(BASE_URL + deleteResourceName);
    return deleteResponse;  
    }

}
