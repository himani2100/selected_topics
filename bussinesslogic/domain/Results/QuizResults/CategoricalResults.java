package domain.Results.QuizResults;

import domain.Questions.Question;
import domain.Results.Results;

import java.util.Map;

/**
 * The result indicates a category based on user answers
 * @version 1.1
 */
public class CategoricalResults extends Results {

    Map<String, Integer> categoryScoreMap;  //key = category, int = score
    Map<Integer, String> questionCategoryMap;   //Int = index of question, String = category selected
    Question[] questions;   //questions in the quiz that the results depend on

    public CategoricalResults(){

    }
}
