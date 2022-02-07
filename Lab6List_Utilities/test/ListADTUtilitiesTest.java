package listadt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListADTUtilitiesTest {
    private ListADT<String> stringList;

    @Before
    public void setup() {

        stringList = new ListADTImpl<>();
    }


    @Test
    public void testStringList() {
        stringList.addFront("won");
        stringList.addFront("Patriots");
        stringList.addBack("Super");
        stringList.addBack("Bowl");
        stringList.add(2, "the");
        assertEquals("(Patriots won the Super Bowl)", stringList.toString());
        assertEquals(5, stringList.getSize());
        assertEquals("Super", stringList.get(3));

        stringList.remove("Patriots");
        stringList.addFront("Falcons");
        stringList.add(1, "did");
        stringList.add(2, "not");
        stringList.remove("won");
        stringList.add(3, "win");


        ListADT<Integer> stringListADT = ListADTUtilities.toList(new Integer[]{1, 2, 3});
        ListADT<Integer> stringListADT1 = ListADTUtilities.toList(new Integer[]{1, 2, 3, 5});
        System.out.println(ListADTUtilities.equals(stringListADT, stringListADT1));

        assertEquals("(Falcons did not win the Super Bowl)", stringList.toString());
        assertEquals(7, stringList.getSize());

    }

    @Test
    public void testMap() {
        // convert the list of strings above to a list that contains the length of
        // each word in the list
        String sentence = "The quick brown fox jumps over the lazy dog";
        String[] words = sentence.split("\\s+");
        for (String w : words) {
            stringList.addBack(w);
        }

        ListADT<Integer> wordLengths = stringList.map(String::length);

        assertEquals("The mapped list's length does not match the original list!",
                stringList.getSize(), wordLengths.getSize());

        for (int i = 0; i < words.length; i++) {
            assertEquals(words[i].length(), (int) wordLengths.get(i));
        }
    }

    @Test
    public void testFilter() {
        // convert the list of strings above to a list that contains the length of
        // each word in the list
        //ListADTUtilities<Integer> tListADTUtilities = null;
        String sentence = "The quick brown fox jumps over the lazy dog";
        String[] words = sentence.split("\\s+");
        for (String w : words) {
            stringList.addBack(w);
        }

//        ListADT<String> wordLengths = stringList.filter(s -> s.length() > 2);
//        //ListADT<String> wordLength = stringList.fold("abc", (a, b) -> a.concat(b)  );
//        assertEquals("The mapped list's length does not match the original list!",
//                stringList.getSize(), wordLengths.getSize());


    }


}