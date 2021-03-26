package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.NumericAnswer;
import domain.Answers.Status;

/**
 * A type of question that expects a number as a response.
 * Numeric questions have a single correct answer that user responses are checked against.
 *
 * @version 1
 */
public class Numeric extends Question{

    NumericAnswer correctAnswer;    //holds the correct answer of this question. Note: this can oly be set in constructor.

    //region constructors
    public Numeric(String questionText,NumericAnswer correctAnswer){
        super(questionText);
        this.correctAnswer = correctAnswer;
        this.correctAnswer.setStatus(Status.CORRECT);
    }

    public Numeric(String questionText,float correctAnswer){
        super(questionText);
        this.correctAnswer = new NumericAnswer(correctAnswer);
        this.correctAnswer.setStatus(Status.CORRECT);

    }

    public Numeric(String questionText, float correctAnswer, float marginOfError){
        super(questionText);
        this.correctAnswer = new NumericAnswer(correctAnswer, marginOfError);
        this.correctAnswer.setStatus(Status.CORRECT);
    }
    //endregion

    /**
     * Answers whose values fall within the margin of error are considered equal to this answer
     * @param error - the acceptable margin of error.
     * @return the margin of error that is set
     */
    public double setMarginOfError(double error){
        return correctAnswer.setErrorAcceptance(error);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {

        if(correctAnswer.Equals(userAnswer))
        {
            return Status.CORRECT;
        }
        return Status.INCORRECT;
    }



}
