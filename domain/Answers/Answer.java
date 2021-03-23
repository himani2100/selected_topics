package domain.Answers;

/**
 * A reaction to a question. Answers values should be immutable. To change an answer value, a new answer should be created. AKA no answer setters should be public.
 * @version 1
 */
public abstract class Answer {

    String userAnswer;              //The reaction that the quiz-taker has to the question
    Status status = Status.PENDING; //Indicates the status of the answer: ex. If the answer is right or wrong

    /**
     * Gets the answer in plain-text
     * @return the value of answer in plain-text
     */
    public abstract String getAnswer();

    /**
     * @return the status of the answer: INCORRECT, CORRECT, NEUTRAL, or PENDING
     */
    public Status getStatus(){
        return this.status;
    }

    /**
     * @param status - the updated status of the answer
     * @return the status of this answer
     */
    public Status setStatus(Status status)
    {
        this.status = status;
        return this.status;
    }

    /**
     * Checks if this answer is equal to another
     * @param a - The answer to check against
     * @return true if the answers are equal, false otherwise
     */
    public boolean Equals(Answer a) {
        return a.getAnswer().hashCode() == this.getAnswer().hashCode();
    }

    @Override
    public java.lang.String toString() {
        return "Answer{" +
                "answer=" + this.userAnswer +","+" status="+this.status+
                '}';
    }
}
