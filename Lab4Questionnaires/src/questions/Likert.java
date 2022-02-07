package questions;

public class Likert implements Question {
    private String questionText;
    private int questionType;

    //Constructor
    public Likert(String questionText){
        this.questionText = questionText;
        this.questionType = 4; //"Likert";
    }


    @Override
    public String getText() {
        return this.questionText;
    }

    @Override
    public int getQuestionType() {
        return this.questionType;
    }

    @Override
    public String answer(String ans) {
        if(ans.equals("1")||ans.equals("2")||ans.equals("3")||ans.equals("4")||ans.equals("5")){
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
