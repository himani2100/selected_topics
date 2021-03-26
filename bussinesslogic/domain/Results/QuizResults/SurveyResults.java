package domain.Results.QuizResults;

import domain.Questions.Question;
import domain.Results.Results;

/**
 * Survey results are only the actual questions answered. The questions are not evaluated
 * @version 1.1
 */
public class SurveyResults extends Results {

    Question[] questions;   //questions in the quiz



    public SurveyResults(){
        questions = new Question[0];
    }

    public SurveyResults(Question[] questions)
    {
        this.questions = questions;
    }

    public void updateResults(Question[] questions){
        this.questions = questions;

    }
}
