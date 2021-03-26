package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.BooleanAnswer;
import domain.Answers.Status;

/**
 * A type of question whose statement is to be judged as either true or false
 *
 * @version 1
 */
public class TrueFalse extends Question {

    BooleanAnswer expectedValue;  //the correct answer of this question

    //region constructor
    public TrueFalse(String questionText, BooleanAnswer correctAnswer){
        super(questionText);
        this.expectedValue = correctAnswer;
    }

    public TrueFalse(String questionText, boolean correctAnswer){
        super(questionText);
        this.expectedValue = new BooleanAnswer(correctAnswer);
    }
    //endregion
    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {
        if(userAnswer.Equals(expectedValue)){
            return Status.CORRECT;
        }
        return Status.INCORRECT;
    }


}
