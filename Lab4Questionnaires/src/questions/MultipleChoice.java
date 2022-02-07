package questions;

public class MultipleChoice implements Question {
    private String questionText;
    private String correctAnswer;
    private int questionType;

    //Constructor for three options
    public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                          String optionTwo, String optionThree) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = 2;//"MultipleChoice";

    }


    //Constructor for four options
    public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                          String optionTwo, String optionThree, String optionFour) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = 2;//"MultipleChoice";

    }


    //Constructor for five options
    public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                          String optionTwo, String optionThree, String optionFour, String optionFive) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = 2;//"MultipleChoice";

    }


    //Constructor for six options
    public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                          String optionTwo, String optionThree, String optionFour,
                          String optionFive, String optionSix) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = 2;//"MultipleChoice";

    }

    //Constructor for seven options
    public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                          String optionTwo, String optionThree, String optionFour,
                          String optionFive, String optionSix,  String optionSeven) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = 2;//"MultipleChoice";

    }

    //Constructor for eight options
    public MultipleChoice(String questionText, String correctAnswer, String optionOne,
                          String optionTwo, String optionThree, String optionFour,
                          String optionFive, String optionSix,  String optionSeven, String optionEight) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.questionType = 2;//"MultipleChoice";

    }

    @Override
    public int getQuestionType() {
        return this.questionType;
    }

    @Override
    public String getText() {
        return this.questionText;
    }

    @Override
    public String answer(String ans) {
        if(ans.equals(correctAnswer)){
            return "Correct";
        }else{
            return "Incorrect";
        }
    }

    @Override
    public int compareTo(Question o) {

        if (this.questionType == o.getQuestionType()) {
            return this.questionText.compareTo(o.getText());
        } else if (this.questionType > o.getQuestionType()) {
            return 1;
        } else {
            return -1;
        }



    }
}
