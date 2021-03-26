package domain.Quizzes;

import domain.Questions.Question;
import domain.Results.QuizResults.ScoredResults;

/**
 * Type of quiz with no right or wrong answer, no score
 * @version 1.1
 */
public class ScoredQuiz extends Quiz{

    public ScoredQuiz(Question[] questions){
        super(new ScoredResults(), questions);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void updateResults() {

    }


}
