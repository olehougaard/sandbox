package dk.via.quiz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class YesNoQuizTest {

    private YesNoQuiz quiz;

    @BeforeEach
    void setUp() {
        quiz = new YesNoQuiz();
    }

    @Test
    void new_quiz_has_no_questions() {
        assertEquals(0, quiz.size());
    }

    @Test
    void adding_question_increases_size() {
        quiz.addQuestion("???", true);
        assertEquals(1, quiz.size());
    }

    @Test
    void adding_question_makes_question_available() {
        quiz.addQuestion("???", true);
        assertEquals("???", quiz.getQuestion(0));
    }

    @Test
    void adding_two_questions_makes_both_questions_available() {
        quiz.addQuestion("???", true);
        quiz.addQuestion("?!", false);
        assertEquals("???", quiz.getQuestion(0));
        assertEquals("?!", quiz.getQuestion(1));
    }

    @Test
    void new_quiz_only_gives_0_grade() {
        assertEquals(0, quiz.grade(List.of()));
    }

    @Test
    void quiz_gives_grade_100_when_all_answers_are_correct() {
        quiz.addQuestion("???", true);
        quiz.addQuestion("?!", false);
        assertEquals(100, quiz.grade(List.of(new Answer(0, true), new Answer(1, false))));
    }

    @Test
    void quiz_gives_grade_0_when_all_answers_are_wrong() {
        quiz.addQuestion("???", true);
        quiz.addQuestion("?!", false);
        assertEquals(0, quiz.grade(List.of(new Answer(0, false), new Answer(1, true))));
    }

    @Test
    void quiz_gives_grade_66_when_two_thirds_of_the_answers_are_wrong() {
        quiz.addQuestion("???", true);
        quiz.addQuestion("?!", false);
        quiz.addQuestion("?!?", false);
        List<Answer> answers = List.of(
                new Answer(1, false),
                new Answer(0, false),
                new Answer(2, false));
        assertEquals(66, quiz.grade(answers));
    }

    @Test
    void grading_throws_an_exception_if_an_answer_is_for_a_nonexistent_question() {
        quiz.addQuestion("???", true);
        quiz.addQuestion("?!", false);
        assertThrows(IllegalArgumentException.class, () -> {
           quiz.grade(List.of(new Answer(2, false)));
        });
    }

    @Test
    void grading_throws_an_exception_if_answers_are_not_for_unique_questions() {
        quiz.addQuestion("???", true);
        quiz.addQuestion("?!", false);
        assertThrows(IllegalArgumentException.class, () -> {
            quiz.grade(List.of(new Answer(0, true), new Answer(0, true)));
        });
    }
}
