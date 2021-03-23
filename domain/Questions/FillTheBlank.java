package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.Status;
import domain.Answers.TermAnswer;

/**
 * A type of question that presents a statement with blank-spaces where a quiz-taker must provide the missing or blank words
 *
 * @version 1
 */
public class FillTheBlank extends Question{

    TermAnswer correctAnswer;   //the answer that fills in the blank.

    //region Constructor
    public FillTheBlank(String questionText, TermAnswer correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }

    public FillTheBlank(String questionText, String blank) {
        super(questionText);
        correctAnswer = new TermAnswer(blank);
    }

    public FillTheBlank(String questionText, String blank, boolean normalize) {
        super(questionText);
        correctAnswer = new TermAnswer(blank,normalize);
    }

    public FillTheBlank(String questionText, String blank, boolean normalize, String[] similarAcceptableTerms) {
        super(questionText);
        correctAnswer = new TermAnswer(blank,similarAcceptableTerms,normalize);
    }

    public FillTheBlank(String questionText, String blank, String[] similarAcceptableTerms) {
        super(questionText);
        correctAnswer = new TermAnswer(blank,similarAcceptableTerms);
    }
    //endregion

    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {

        if(userAnswer.Equals(correctAnswer)){
            return Status.CORRECT;
        }
        return Status.INCORRECT;
    }


}
