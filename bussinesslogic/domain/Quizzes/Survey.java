package domain.Quizzes;

import domain.Questions.Question;
import domain.Results.QuizResults.SurveyResults;

/**
 * Type of quiz with no right or wrong answer, no score
 * @version 1.1
 */
public class Survey extends Quiz{

    public Survey(Question[] questions){
        super(new SurveyResults(), questions);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void updateResults() {

    }


}
