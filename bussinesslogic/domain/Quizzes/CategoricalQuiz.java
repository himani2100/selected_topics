package domain.Quizzes;

import domain.Questions.MultipleChoice;
import domain.Questions.Question;
import domain.Results.QuizResults.CategoricalResults;
import domain.Results.Results;

/**
 * Each question leads to a category as a result.
 * Only works with multiple choice questions.
 * @version 1.1
 */
public class CategoricalQuiz extends  Quiz{


    public CategoricalQuiz(MultipleChoice[] questions) {
        super(new CategoricalResults(), questions);
    }

    @Override
    public void updateResults() {

    }
}
