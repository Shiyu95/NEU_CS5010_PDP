package questions;

public class TrueFalse implements Question {
    private String questionText;
    private String correctAnswer;
    private int questionType;

    //Constructor
    public TrueFalse(String questionText, String correctAnswer){
        this.questionText = questionText;
        this.correctAnswer =  correctAnswer;
        this.questionType =  1; //"TrueFalse";

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
