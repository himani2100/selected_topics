package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.Status;

/**
 * An expression aimed to elicit a response.
 * @version 1
 */
public abstract class Question {

    String questionText;        //expression that is aimed to elicit response
    Answer userAnswer;          //response to the question

    public Question(String questionText){
        this.setQuestion(questionText);
    }

    //region questionText
    /**
     * Gets the question statement
     * @return The statement that the question is proposing
     */
    public String getQuestion(){
        return this.questionText;
    }

    /**
     * Sets the question statement of this object. This can only be set in constructor
     * @param questionText - The statement to represent a question
     * @return the question statement of this object
     */
    private String setQuestion(String questionText){

        boolean isValid = this.isValidQuestionText(questionText);   //check if the format is valid

        if(isValid)
        {
            this.questionText = questionText;   //if it is valid -> set this.questionText
        }
        return this.getQuestion();
    }

    /**
     * Verifies that an input property is valid for this object
     * @param question - The question text whose format is to be checked before it can be set to this object
     * @return true if format is valid; false otherwise
     */
    protected boolean isValidQuestionText(String question) {
        return question.trim().length() > 0;
    }

    /**
     * Is only called on quiz-taker answer set
     * @param userAnswer - quiz-taker response to the question
     * @return the status of userAnswer
     */
    private Status updateStatusOnUserAnswerSet(Answer userAnswer){

        Status updatedStatus = this.getStatusBasedOn(userAnswer);
        return this.userAnswer.setStatus(updatedStatus);
    }

    /**
     * Does not update status; only returns status expected based on userAnswer.
     * @param userAnswer - response to this question
     * @return the status that would be set based on the answer provided
     */
    protected abstract Status getStatusBasedOn(Answer userAnswer);
    //endregion

    //region userAnswer

    /**
     * Gets user response as plain-text
     * @return the user response
     */
    public String getUserAnswer(){
        return this.userAnswer.getAnswer();
    }

    /**
     * This function sets the response of the quiz-taker to the internal variable, "userAnswer". The function then returns the value of "userAnswer", if the value has been modified then the value returned should match the input variable "a". If unmodified, then the return would not match "a".
     * @param a - The response a quiz-taker gives to this question
     * @return The response that this question has
     */
    public Answer setUserAnswer(Answer a){
        boolean isValid = this.isValidUserAnswer(a);    //check if the format is valid

        if(isValid)
        {
            this.userAnswer = a;        //if it is valid -> set this.questionText
            this.updateStatusOnUserAnswerSet(a);
        }

        return this.userAnswer;
    }

    /**
     * Verifies that an input property is compatible with this object. The reason for the existence of this methods is so that it can be override without affecting SetUserAnswer.
     * @param a - the user input, checks if the format of this answer is valid
     * @return true if format is valid; false otherwise
     */
    protected boolean isValidUserAnswer(Answer a){
        return true;
    }

    //endregion

    /**
     * Indicates the status of the question response
     * @return Status.Incorrect if answer is incorrect. Status.CORRECT if answer is correct. Status.NEUTRAL if answer is neither correct nor incorrect. Status.PENDING if the answer has not been graded yet.
     */
    public Status getStatus() {
        return this.userAnswer.getStatus();
    }

}
