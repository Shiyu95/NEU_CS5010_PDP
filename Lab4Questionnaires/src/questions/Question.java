package questions;

public interface Question extends Comparable<Question> {
    int getQuestionType();
    String getText();
    String answer(String ans);
}
