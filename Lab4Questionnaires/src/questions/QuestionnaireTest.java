package questions;

import org.junit.Test;
import questions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import static org.junit.Assert.*;

public class QuestionnaireTest {
    private static Question question;


    @Test
    public void testLikert() {
        Question e = new Likert("Do you like apple?");
        assertEquals("Correct", e.answer("1"));
        assertEquals("Incorrect", e.answer("0"));
        assertEquals("Incorrect", e.answer("6"));
    }


    @Test
    public void testMultipleChoice() {
        Question e = new MultipleChoice("What is 10/2 equal to?","5","1", "5","5");
        assertEquals("Correct", e.answer("5"));
        assertEquals("Incorrect", e.answer("0"));
        assertEquals("Incorrect", e.answer("1"));
    }



    @Test
    public void testMultipleSelect() {
        Question e = new MultipleSelect("What is one hour equal to? ", "1 3", // correct answer
                 "60 minutes", "60 seconds", "3600 seconds", "half a day");
    assertEquals("Correct", e.answer("1 3"));
    assertEquals("Incorrect", e.answer("2"));
    assertEquals("Incorrect", e.answer("1 2"));
    assertEquals("Incorrect", e.answer("3 4"));
    assertEquals("Incorrect", e.answer("1 2 3 4"));
 }


    @Test
    public void testTrueFalse() {
        Question e = new TrueFalse("One hour equal to 60 minutes","True");
        assertEquals("Correct", e.answer("True"));
        assertEquals("Incorrect", e.answer("False"));
        assertEquals("Incorrect", e.answer("6"));
    }

    @Test
    public void  TestSort(){

        Question e2 = new Likert("Do you like apple?");
        Question e7 = new Likert("am you like apple?");
        List<Question> list = new ArrayList();
        list.add(e2);
        list.add(e7);
        Collections.sort(list);
        for(Question q:list){
            System.out.println(q.getText());
            //assertEquals("", q.getText());
        }
        assertEquals("", list);
    }

}