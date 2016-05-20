/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.path.json.JsonPath.*;
import com.jayway.restassured.response.Response;
//import static groovy.xml.dom.DOMCategory.name;
import java.util.UUID;
import static org.junit.Assert.assertEquals;
//import static sun.security.jca.ProviderList.newList;


public class MyFirstRestTest {
    private static final String BASE_URL = "http://localhost:8080/librarytest/rest/";    
    
    
    public MyFirstRestTest() {    
    }
    
    @Test
    public void testFetchBook(){
        Response response = new BookOperations().getBook(3);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 200", 200, response.statusCode());
    }
 /*@Test
    public void testFetchAllBooks(){
        Response response = new BookOperations().getAllBooks();
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 200", 200, response.statusCode());
    }
    @Test
    public void testFetchInvalidBookReturns404(){
        Response response = new BookOperations().getBook(235678);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 404", 404, response.statusCode());
    }
    
    @Test
    public void testAddNewBook(){
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.createRandomBook();
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
                
        String expectedTitle = from(bookOperations.getLatestJsonString()).getString("book.title");
        String expectedDescription = from(bookOperations.getLatestJsonString()).getString("books.description");
        String expectedIsbn = from(bookOperations.getLatestJsonString()). getString("books.isbn");
        
        Response getResponse = bookOperations.getAllBooks() ;
        String fetchedTitle = getResponse.jsonPath() .getString("books.book[-1].title");
        String fetchedDescription = getResponse.jsonPath() .getString("books.book[-1].description");
        String fetchedIsbn = getResponse.jsonPath() .getString("books.book[-1].isbn");
               
        assertEquals(expectedTitle,fetchedTitle);
        assertEquals(expectedDescription,fetchedDescription);
        assertEquals(expectedIsbn,fetchedIsbn);
    }
    @Test
    public void testAddNewBookNagativ1(){
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.createRandomBook();
        System.out.println("Status code:" + postResponse.statusCode());
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
                
        String expectedTitle = from(bookOperations.getLatestJsonString()).getString("book.title");
        String expectedDescription = from(bookOperations.getLatestJsonString()).getString("books.description");
        String expectedIsbn = from(bookOperations.getLatestJsonString()). getString("books.isbn");
        
        Response getResponse = bookOperations.getAllBooks() ;
        String fetchedTitle = getResponse.jsonPath() .getString("books.book[-1].title");
        String fetchedDescription = getResponse.jsonPath() .getString("books.book[-1].description");
        String fetchedIsbn = getResponse.jsonPath() .getString("books.book[-1].isbn");
               
        assertEquals(expectedTitle,fetchedTitle);
        assertEquals(expectedDescription,fetchedDescription);
        assertEquals(expectedIsbn,fetchedIsbn);
        
        postResponse = bookOperations.createRandomBook();
        System.out.println("Status code:" + postResponse.statusCode());
        assertEquals("post response should have status code 400", 400, postResponse.statusCode());
    }
    @Test
    public void testAddNewBookNagativ2(){ 
        // book contained an author which had no id field 
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.createRandomBook();
        System.out.println("Status code:" + postResponse.statusCode());
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
                
        String expectedTitle = from(bookOperations.getLatestJsonString()).getString("book.title");
        String expectedDescription = from(bookOperations.getLatestJsonString()).getString("books.description");
        String expectedIsbn = from(bookOperations.getLatestJsonString()). getString("books.isbn");
        
        Response getResponse = bookOperations.getAllBooks() ;
        String fetchedTitle = getResponse.jsonPath() .getString("books.book[-1].title");
        String fetchedDescription = getResponse.jsonPath() .getString("books.book[-1].description");
        String fetchedIsbn = getResponse.jsonPath() .getString("books.book[-1].isbn");
               
        assertEquals(expectedTitle,fetchedTitle);
        assertEquals(expectedDescription,fetchedDescription);
        assertEquals(expectedIsbn,fetchedIsbn);
        
      //  AuthorOperations additionalAuthor = new AuthorOperations();
    //    String templeteAuthor = additionalAuthor.prepareNewAuthorSpec();
            
        //String bookTemplate = bookOperations.createBookRandomTemplate(templeteAuthor+"\n"); 
        //Response postResponse = bookOperations.createRandomBook();
        System.out.println("Status code:" + postResponse.statusCode());
        assertEquals("post response should have status code 400", 400, postResponse.statusCode());
    }
    
    @Test
    public void testAddNewBookNagativ3(){
        // book contained an author which didn't exist in database.
        AuthorOperations additionalAuthor = new AuthorOperations();
        String authorTemplete = additionalAuthor.prepareNewAuthorSpec();
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.createRandomBook();
        System.out.println("Status code:" + postResponse.statusCode());
        assertEquals("post response should have status code 400", 400, postResponse.statusCode());
                
    }
    @Test
    public void testUppdateBook(){
        BookOperations bookOperations = new BookOperations();
        String bookTemplate = bookOperations.createRandomBookTemplate("Hadeel Hatam");  
        Response postResponse = bookOperations.createBook(bookTemplate);
        assertEquals("uppdate response should have status code 200", 200, postResponse.statusCode());
        int t = bookOperations.getId();          
        String newTitle = "livet i Dubai"; 
        String newIsbn = "2345";
        String newDescription = "boken descripe min liv i Dubai";

        assertEquals(newTitle,from(bookOperations.getLatestJsonString()).getString("book.title"));
        assertEquals(newIsbn,from(bookOperations.getLatestJsonString()).getString("book.isbn"));
        assertEquals(newDescription,from(bookOperations.getLatestJsonString()).getString("book.description"));
    
        Response putResponse = given().contentType(ContentType.JSON).queryParam(BASE_URL+"books/id", t).body(bookOperations).put(BASE_URL+"books");  
        System.out.println("Status code: " + putResponse.getStatusCode());  
    }*/
///////////////////////////////////////////////////////////////////////////////////////////////////////7
 /*@Test 
   public void testUppdateBookNegativ1() { 
       //400 The book contained an author with no id field set or the book contained an author that didn't exist in the database. 
        Response response = new BookOperations().getBook(3);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 200", 200, response.statusCode());
    }*/ 
 ////////////////////////////////////////////////////////////////////////////////////////////////////7
 /*   @Test 
    public void testUppdateBookNegativ2() { 
     //404 The book not found. 
        Response response = new BookOperations().getBook(235978);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 404", 404, response.statusCode());
    } 

        
  @Test
    public void testFetchBookId(){
        BookOperations bookOperations = new BookOperations(); 
        String bookTemplate = bookOperations.createRandomBookTemplate("");  
        Response postResponse = bookOperations.createBook(bookTemplate);  
        
        int t = bookOperations.getId(); 
        Response response = bookOperations.get(t); 
        System.out.println("Status code: " + response.getStatusCode()); 
        assertEquals("Status code should be 200", 200, response.statusCode()); 
    }
    
@Test  
public void testFetchBookIdNegativ() { //404 The book was not found. 
    BookOperations bookOperations = new BookOperations(); 
    Response postResponse = bookOperations.get(333333); 
    System.out.println("Status code: " + postResponse.getStatusCode()); 
    assertEquals("Status code should be 404", 404, postResponse.statusCode()); 
    }  

    
    @Test
    public void testDeletBookId(){
        BookOperations bookOperations = new BookOperations(); 
        String bookTemplate = bookOperations.createRandomBookTemplate("");  
        Response postResponse = bookOperations.createBook(bookTemplate);  
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
        int t = bookOperations.getId();
        Response deleteResponse = new BookOperations().deleteBook(t);
        assertEquals("Delet method should return 204", 204, deleteResponse.getStatusCode()); 
        System.out.println("Status code: " + deleteResponse.getStatusCode()); 
    } 
@Test 
public void testDeleteBookIdNegativ() { //404 The book was not found. 
        BookOperations bookOperations = new BookOperations(); 
        String bookTemplate = bookOperations.createRandomBookTemplate("");  
        Response postResponse = bookOperations.createBook(bookTemplate);  
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
        int t = bookOperations.getId(); 
        Response deleteResponse = new BookOperations().deleteBook(t); 
        assertEquals("Delet method should return 204", 204, deleteResponse.getStatusCode()); 
        Response getDeletedBookResponse = new BookOperations().getBook(t); 
        assertEquals("Get deleted book should return 404", 404, getDeletedBookResponse.getStatusCode()); 
        System.out.println("Status code: " + getDeletedBookResponse.getStatusCode()); 
    } 

    
    @Test
    public void testFetchbooksbyauthor_authorId(){
        //Get all the books of the asked author from the database. 
        BookOperations bookOperations = new BookOperations(); 
        Response response = bookOperations.getBooksAuthor(3); 
        System.out.println("Status code: " + response.getStatusCode()); 
         assertEquals("Status code should be 200", 200, response.statusCode()); 
    }
    @Test//Try to get all the books of the asked author from the database, when there is no such author. 
    public void testFetchbooksbyauthor_authorIdNegativ(){
        BookOperations bookOperations = new BookOperations(); 
        Response response = bookOperations.getBooksAuthor(44444); 
        System.out.println("Status code: " + response.getStatusCode()); 
        assertEquals("Status code should be 200", 200, response.statusCode()); 
    }
  @Test 
       public void testFetchAuthersBook() {//200 Get authors of the specified book. 
        BookOperations bookOperations = new BookOperations(); 
        Response getResponse = bookOperations.getBooksbookidAuthors(3); 
        System.out.println("Status code: " + getResponse.getStatusCode()); 
        assertEquals("Status code should be 200", 200, getResponse.statusCode()); 
            
       } 
        
     @Test 
       public void testFetchAuthersBookNegativ() { //404 The book was not  
        BookOperations bookOperations = new BookOperations(); 
        Response getResponse = bookOperations.getBooksbookidAuthors(88888); 
        System.out.println("Status code: " + getResponse.getStatusCode()); 
        assertEquals("Status code should be 404", 404, getResponse.statusCode()); 
        } 
  
    
    @Test
    public void testFetchbooks_bookid_authors(){//200 Add an author to the specified book. 
        AuthorOperations additionalAuthor = new AuthorOperations(); 
        Response response = additionalAuthor.addbooksBookidAuthors(2); 
        System.out.println("Status code: " + response.getStatusCode()); 
        assertEquals("Status code should be 200", 200, response.statusCode()); 
    }
    
    @Test  
    public void testFetchbooks_bookid_authorsNegativ1() {//400 The author did not have the id field set 
        AuthorOperations additionalAuthor = new AuthorOperations(); 
        String postBody = additionalAuthor.addbooksBookidAuthors(); 
        Response response = additionalAuthor.addAdditionalAuthorWithoutIdToBookN(1); 
        System.out.println("Status code: " + response.getStatusCode()); 
        assertEquals("Status code should be 400", 400, response.statusCode()); 
    } 
 
    @Test 
    public void testFetchBooks_bookid_authorsNegativ2() {//400 The author was already an author of this book.  
        AuthorOperations additionalAuthor = new AuthorOperations(); 
        Response response = additionalAuthor.addAdditionalAuthorAlreadyUsedToBookN(2);
        System.out.println("test #13.2 Status code: " + response.getStatusCode()); 
        assertEquals("Status code should be 400", 400, response.statusCode()); 
    } 
       
    @Test  
     public void testFetchBooks_bookid_authorsNegativ3() { //404 The book was not found.  
        AuthorOperations additionalAuthor = new AuthorOperations(); 
        Response response = additionalAuthor.addbooksBookidAuthors(88888); 
        System.out.println("test #13.3 Status code: " + response.getStatusCode()); 
        assertEquals("Status code should be 404", 404, response.statusCode()); 
    } 
*/

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/*     @Test
    public void testAddbooks_bookid_authors(){
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.createRandomBook();
        assertEquals("post response should have status code 200", 200, postResponse.statusCode());
                
        String expectedAuthor = from(bookOperations.getLatestJsonString()).getString("book.author");
        //String expectedDescription = from(bookOperations.getLatestJsonString()).getString("books.description");
        //String expectedIsbn = from(bookOperations.getLatestJsonString()). getString("books.isbn");
        
        Response getResponse = bookOperations.getAllBooks() ;
        //String fetchedTitle = getResponse.jsonPath() .getString("books.book[-1].title");
        //String fetchedDescription = getResponse.jsonPath() .getString("books.book[-1].description");
        //String fetchedIsbn = getResponse.jsonPath() .getString("books.book[-1].isbn");
        
        
        assertEquals("Status kod should be 400", 400, expectedAuthor);
                //assertEquals(expectedDescription,fetchedDescription);
        //assertEquals(expectedIsbn,fetchedIsbn);
    }
    @Test
    public void testUppdatebooks_bookid_authors(){
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.getBook(1);
        assertEquals("uppdate response should have status code 200", 200, postResponse.statusCode());
                
        String newTitle = "livet i Sverige"; 
        String newIsbn = "3245";
        String newDescription = "boken descripe min liv i Serige";

        assertEquals(newTitle,from(bookOperations.getLatestJsonString()).getString("book.title"));
        assertEquals(newIsbn,from(bookOperations.getLatestJsonString()).getString("book.isbn"));
        assertEquals(newDescription,from(bookOperations.getLatestJsonString()).getString("book.description"));
    }
*/
 
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*@Test
public void testFetchAllAuthors (){
    //Get all books from database
    Response response = new AuthorOperations().getAllAuthors();
    System.out.println("Status code: " + response.getStatusCode());
    assertEquals( "status code should be 200", 200, response.statusCode());
}

@Test
    public void testFetchAuthor(){
        Response response = new AuthorOperations().getAuthor(3);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 200", 200, response.statusCode());
  }
    @Test
    public void testFetchInvalidAuthorReturns404(){
        Response response = new AuthorOperations().getAuthor(235978);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 404", 404, response.statusCode());
  }
    
 @Test
    public void testAddNewAuthor(){
        AuthorOperations authorOperations = new AuthorOperations();
        Response postResponse = authorOperations.createRandomAuthor();
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
                
        String expectedName = from(authorOperations.getLatestJsonString()).getString("author.name");
        
        Response getResponse = authorOperations.getAllAuthors() ;
        String fetchedName = getResponse.jsonPath() .getString("authors.author[-1].name");
                
        assertEquals(expectedName,fetchedName);
    }   

    @Test
    public void testAddNewAuthorNegativ(){
        AuthorOperations authorOperations1 = new AuthorOperations();
        AuthorOperations authorOperations2 = new AuthorOperations();

        Response postResponse1 = authorOperations1.createRandomAuthor();
        assertEquals("post response should have status code 201", 201, postResponse1.statusCode());
                
        int authorId1 = authorOperations1.getId();
      
        Response postResponse2 = authorOperations2.createNewAuthorTemplate(UUID.randomUUID().toString(), authorId1);
        System.out.println("Status code: " + postResponse2.statusCode());
        assertEquals("post response should have status code 400", 400, postResponse2.statusCode());

    }
    
    @Test
    public void testUppdateAuthor(){// behöver hjälp för fixa
        //Uppdate a author with new data (Put).  
        AuthorOperations authorOperations = new AuthorOperations();
        Response response = new AuthorOperations().createNewAuthor();
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 201", 201, response.statusCode());
        authorOperations.setName("Hadeel Hatam");
        int id = authorOperations.getId(); 
        System.out.println(id);  
      //  assertEquals(newName,from(authorOperations.getLatestJsonString()).getString("author.name"));
   
       Response putResponse = given().contentType(ContentType.JSON).body(authorOperations).put(BASE_URL+"authors");  
       Response response1 =  given().accept(ContentType.JSON).get(BASE_URL+"authors/"+id).prettyPeek();  
 
        
    }
  
    @Test
    public void testUppdateAuthorNegativ(){// behöver hjälp för att fixa
        //404 The author not found.
        AuthorOperations authorOperations = new AuthorOperations();
        AuthorOperations authorOperations1 = new AuthorOperations();

        Response response = new AuthorOperations().createNewAuthor();
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 201", 201, response.statusCode());
        authorOperations.setName("Hadeel Hatam");
        int id = authorOperations.getId(); 
        System.out.println(id);  
        Response putResponse = given().contentType(ContentType.JSON).body(authorOperations).put(BASE_URL+"authors");  
        Response response1 =  given().accept(ContentType.JSON).get(BASE_URL+"authors/"+id).prettyPeek();  

        int authorId1 = authorOperations.getId();
      
        Response postResponse2 = authorOperations1.createNewAuthorTemplate(UUID.randomUUID().toString(), authorId1);
        System.out.println("Status code: " + postResponse2.statusCode());
        assertEquals("post response should have status code 400", 400, postResponse2.statusCode());
    }
    
    @Test
    public void testFetchAuthorId(){
        Response response = new AuthorOperations().getAuthor(3);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 200", 200, response.statusCode());
     }
   @Test
    public void testFetchAuthorIdNegativ(){
        Response response = new AuthorOperations().getAuthor(33333);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals( "status code should be 404 if author not found", 404, response.statusCode());
     }
 @Test
    public void testDeletAuthorId(){
        Response postResponse = new AuthorOperations().createRandomAuthor();
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
        
        Response deletResponse = new AuthorOperations().deleteAuthor(2);
        int fetchedId = deletResponse.jsonPath().getInt("authors.author.id");
        
        Response deleteResponse = new AuthorOperations().deleteAuthor(fetchedId);
        assertEquals("delete method should return 204", 204, deleteResponse.getStatusCode());
       
  } 
@Test
    public void testDeletAuthorIdNegativ(){
        Response postResponse = new AuthorOperations().createRandomAuthor();
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
        
        Response deletResponse = new AuthorOperations().deleteAuthor(2);
        int fetchedId = deletResponse.jsonPath().getInt("authors.author.id");
        
        Response deleteResponse = new AuthorOperations().deleteAuthor(fetchedId);
        assertEquals("delete method should return 204", 204, deleteResponse.getStatusCode());

         deleteResponse = new AuthorOperations().deleteAuthor(fetchedId);
        assertEquals("delete method should return 404", 404, deleteResponse.getStatusCode());
        System.out.println("status code: " +deleteResponse.getStatusCode());
  } 
*/
}  
    
    
    

