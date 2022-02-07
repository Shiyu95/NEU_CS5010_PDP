import cs5010.lab00.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;
  private Person shiyu;

  @Before
  public void setUp() {

    john = new Person("John", "Doe", 1945);
    shiyu = new Person("Shiyu", "Huang", 1995);
  }

  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());
    assertEquals("Shiyu", shiyu.getFirstName());

  }

  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
    assertEquals("Huang", shiyu.getLastName());
  }

  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
    assertNotEquals(1993, shiyu.getYearOfBirth());
  }

}
