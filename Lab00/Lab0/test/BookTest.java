import org.junit.Before;
import org.junit.Test;
import cs5010.lab00.Book;
import cs5010.lab00.Person;

import static org.junit.Assert.*;

public class BookTest {
    private Book harryPotter;
    private Person author;
    @Before
    public void Setup(){
        author = new Person("J.K","Rowling",1965);
        harryPotter = new Book("Harry Potter", author, 46);
    }
    @Test
    public void testTitle(){
         assertEquals("Harry Potter",harryPotter.getTitle());
    }

    @Test
    public void testPrice(){
        assertNotEquals(54, harryPotter.getPrice());
    }

    @Test
    public void testAuthor(){
        assertEquals("Rowling",harryPotter.getAuthor().getLastName());
        assertEquals("J.K",harryPotter.getAuthor().getFirstName());
        assertEquals(1965,harryPotter.getAuthor().getYearOfBirth());
    }
}