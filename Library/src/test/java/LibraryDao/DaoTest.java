/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import Model.Author;
import Model.Book;
import Model.Publisher;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author benli
 */
public class DaoTest {
    
    Dao dao;
    
    
        
    public DaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx 
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
    
        dao = ctx.getBean("Dao", Dao.class);
        
        List<Book> books = dao.getAllBooks();
        for (Book currentBook : books) {
            dao.deleteBook(currentBook.getBookId());
        }
        
        List<Author> authors = dao.getAllAuthors();
        for (Author currentAuthor : authors) {
            dao.deleteAuthor(currentAuthor.getAuthorId());
        }
        
        List<Publisher> publishers = dao.getAllPublishers();
        for (Publisher currentPublisher : publishers) {
            dao.deletePublisher(currentPublisher.getPublisherId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAuthor method, of class Dao.
     */
    @Test
    public void testAddAuthor() {
        Author author = new Author();
        author.setFirstName("stan");
        author.setLastName("darsh");
        author.setStreet("24 this street");
        author.setCity("home city");
        author.setState("MN");
        author.setZip("12345");
        author.setPhone("1234567890");
        
        dao.addAuthor(author);
        
        Author fromDao = dao.getAuthorById(author.getAuthorId());
        assertEquals(fromDao, author);
    }

    /**
     * Test of deleteAuthor method, of class Dao.
     */
    @Test
    public void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("stan");
        author.setLastName("darsh");
        author.setStreet("24 this street");
        author.setCity("home city");
        author.setState("MN");
        author.setZip("12345");
        author.setPhone("1234567890");
        
        dao.addAuthor(author);
        
        Author fromDao = dao.getAuthorById(author.getAuthorId());
        assertEquals(fromDao, author);
        dao.deleteAuthor(author.getAuthorId());
        assertNull(dao.getAuthorById(author.getAuthorId()));
    }

    /**
     * Test of updateAuthor method, of class Dao.
     */
    @Test
    public void testUpdateAuthor() {
    }

    /**
     * Test of getAuthorById method, of class Dao.
     */
    @Test
    public void testGetAuthorById() {
    }

    /**
     * Test of getAllAuthors method, of class Dao.
     */
    @Test
    public void testGetAllAuthors() {
    }

    /**
     * Test of addBook method, of class Dao.
     */
    @Test
    public void testAddBook() {
        Publisher publisher = new Publisher();
        publisher.setName("pub 1");
        publisher.setStreet("123 that street");
        publisher.setCity("that city");
        publisher.setState("MN");
        publisher.setZip("12345");
        publisher.setPhone("1234567890");
        
        dao.addPublisher(publisher);
        
        Author author = new Author();
        author.setFirstName("stan");
        author.setLastName("darsh");
        author.setStreet("24 this street");
        author.setCity("home city");
        author.setState("MN");
        author.setZip("12345");
        author.setPhone("1234567890");
        
        dao.addAuthor(author);
        
        Book b = new Book();
        b.setTitle("A Book");
        b.setIsbn("12345");
        b.setPrice(new BigDecimal("3.23"));
        b.setPublishDate(LocalDate.parse("1999-01-01", DateTimeFormatter.ISO_DATE));
        b.setPublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        b.setAuthors(authors);
        
        dao.addBook(b);
        
        Book fromDao = dao.getBookById(b.getBookId());
        
        assertEquals(fromDao, b);
        
        
    }

    /**
     * Test of deleteBook method, of class Dao.
     */
    @Test
    public void testDeleteBook() {
         Publisher publisher = new Publisher();
        publisher.setName("pub 1");
        publisher.setStreet("123 that street");
        publisher.setCity("that city");
        publisher.setState("MN");
        publisher.setZip("12345");
        publisher.setPhone("1234567890");
        
        dao.addPublisher(publisher);
        
        Author author = new Author();
        author.setFirstName("stan");
        author.setLastName("darsh");
        author.setStreet("24 this street");
        author.setCity("home city");
        author.setState("MN");
        author.setZip("12345");
        author.setPhone("1234567890");
        
        dao.addAuthor(author);
        
        Book b = new Book();
        b.setTitle("A Book");
        b.setIsbn("12345");
        b.setPrice(new BigDecimal("3.23"));
        b.setPublishDate(LocalDate.parse("1999-01-01", DateTimeFormatter.ISO_DATE));
        b.setPublisher(publisher);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        b.setAuthors(authors);
        
        dao.addBook(b);
        
        Book fromDao = dao.getBookById(b.getBookId());
        
        assertEquals(fromDao, b);
        dao.deleteBook(b.getBookId());
        assertNull(dao.getBookById(b.getBookId()));
    }

    /**
     * Test of updateBook method, of class Dao.
     */
    @Test
    public void testUpdateBook() {
    }

    /**
     * Test of getBookById method, of class Dao.
     */
    @Test
    public void testGetBookById() {
    }

    /**
     * Test of getBooksByAuthorId method, of class Dao.
     */
    @Test
    public void testGetBooksByAuthorId() {
    }

    /**
     * Test of getBooksByPublisherId method, of class Dao.
     */
    @Test
    public void testGetBooksByPublisherId() {
    }

    /**
     * Test of getAllBooks method, of class Dao.
     */
    @Test
    public void testGetAllBooks() {
    }

    /**
     * Test of addPublisher method, of class Dao.
     */
    @Test
    public void testAddPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("pub 1");
        publisher.setStreet("123 that street");
        publisher.setCity("that city");
        publisher.setState("MN");
        publisher.setZip("12345");
        publisher.setPhone("1234567890");
        
        dao.addPublisher(publisher);
        
        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        
        assertEquals(fromDao, publisher);
    }

    /**
     * Test of deletePublisher method, of class Dao.
     */
    @Test
    public void testDeletePublisher() {
        
        Publisher publisher = new Publisher();
        publisher.setName("pub 1");
        publisher.setStreet("123 that street");
        publisher.setCity("that city");
        publisher.setState("MN");
        publisher.setZip("12345");
        publisher.setPhone("1234567890");
        
        dao.addPublisher(publisher);
        
        Publisher fromDao = dao.getPublisherById(publisher.getPublisherId());
        assertEquals(fromDao, publisher);
        dao.deletePublisher(publisher.getPublisherId());
        assertNull(dao.getPublisherById(publisher.getPublisherId()));
    }

    /**
     * Test of updatePublisher method, of class Dao.
     */
    @Test
    public void testUpdatePublisher() {
    }

    /**
     * Test of getPublisherById method, of class Dao.
     */
    @Test
    public void testGetPublisherById() {
    }

    /**
     * Test of getAllPublishers method, of class Dao.
     */
    @Test
    public void testGetAllPublishers() {
    }

    public class DaoImpl implements Dao {

        public void addAuthor(Author author) {
        }

        public void deleteAuthor(int authorId) {
        }

        public void updateAuthor(Author author) {
        }

        public Author getAuthorById(int id) {
            return null;
        }

        public List<Author> getAllAuthors() {
            return null;
        }

        public void addBook(Book book) {
        }

        public void deleteBook(int bookId) {
        }

        public void updateBook(Book book) {
        }

        public Book getBookById(int id) {
            return null;
        }

        public List<Book> getBooksByAuthorId(int authorId) {
            return null;
        }

        public List<Book> getBooksByPublisherId(int publisherId) {
            return null;
        }

        public List<Book> getAllBooks() {
            return null;
        }

        public void addPublisher(Publisher publisher) {
        }

        public void deletePublisher(int publisherId) {
        }

        public void updatePublisher(Publisher publisher) {
        }

        public Publisher getPublisherById(int id) {
            return null;
        }

        public List<Publisher> getAllPublishers() {
            return null;
        }
    }
    
}
