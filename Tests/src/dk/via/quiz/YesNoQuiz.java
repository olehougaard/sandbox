package dk.via.quiz;

import java.util.ArrayList;
import java.util.List;

record Question(String question, boolean answer) {
}

public class YesNoQuiz {
    private final List<Question> qs;

    public YesNoQuiz() {
        qs = new ArrayList<>();
    }

    public int size() {
        return qs.size();
    }

    public void addQuestion(String question, boolean isTrue) {
        qs.add(new Question(question, isTrue));
    }

    public String getQuestion(int i) {
        return qs.get(i).question();
    }

    public int grade(List<Answer> answers) {
        boolean outOfBounds = answers.stream()
                .mapToInt(Answer::getQuestionNo)
                .anyMatch(a -> a < 0 || a >= size());
        if (outOfBounds) {
            throw new IllegalArgumentException("Invalid question number");
        }

        long distinctQuestionsAnswered = answers.stream()
                .mapToInt(Answer::getQuestionNo)
                .distinct()
                .count();
        if (distinctQuestionsAnswered < answers.size()) {
            throw new IllegalArgumentException("Double answer");
        }

        if (qs.size() == 0) return 0;
        long correctCount = answers.stream()
                .filter(a -> this.qs.get(a.getQuestionNo()).answer() == a.getAnswer())
                .count();
        return (int) (100 * correctCount / qs.size());
    }
}
