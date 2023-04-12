package dk.via.quiz;

public class Answer {
    private final int questionNo;
    private final Boolean answer;

    public Answer(int questionNo, Boolean answer) {
        this.questionNo = questionNo;
        this.answer = answer;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public Boolean getAnswer() {
        return answer;
    }
}
