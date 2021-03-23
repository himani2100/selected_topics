package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.ListAnswer;
import domain.Answers.Status;

/**
 * A type of question, where given a set of items, the quiz-taker must order the items
 *
 * @version 1
 */
public class Ordering extends Question{

    ListAnswer correctOrder;    //the correct order of the items

    public Ordering(String questionText, ListAnswer correctOrder) {
        super(questionText);
        this.correctOrder = correctOrder;
    }

    public Ordering(String questionText, Object[] correctOrder) {
        super(questionText);
        this.correctOrder = new ListAnswer(correctOrder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {
        if(userAnswer.Equals(correctOrder)){
            return Status.CORRECT;
        }

        return Status.INCORRECT;
    }


}
