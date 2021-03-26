package domain.Results.QuizResults;

import domain.Questions.Question;
import domain.Results.Results;

import java.util.Map;

/**
 * @version 1.1
 */
public class ScoredResults extends Results {

    float maxScore = 0;     //the maximum score to achieve in this quiz
    float userScore = 0;    //the score received by a  user based on questions answered
    Map<Integer, Float> questionScoreMap; //key = question index, value = score
    Question[] questions;   //Questions in this quiz

    public ScoredResults(){

    }
}
