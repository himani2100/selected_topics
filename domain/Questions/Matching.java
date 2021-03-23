package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.Status;

/**
 * A type of question that divides an item into two sets. The user must match the each item with a specific attribute.
 *
 * @version 1
 */
public class Matching extends Question{

    public Matching(String questionText) {
        super(questionText);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {
        return null;
    }

}
