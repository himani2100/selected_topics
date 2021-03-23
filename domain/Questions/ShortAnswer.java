package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.Status;

/**
 * A type of question that requires user to input a brief response to a question.
 * By default, the status of these questions is NEUTRAL, however this can be changed via SetStatus function.
 * Everytime a new answer is input, the status will always revert back to the default state
 *
 * @version 1
 */
public class ShortAnswer extends Question {


    int maxLen = 10000;  //maximum number of characters
    int minLen = 0;     //minimum number of characters
    boolean hasMaxLen = false;  //by default false, aka answers do not have a length restriction. This variable acts as a hook

    //region Constructor
    public ShortAnswer(String questionText)
    {
        super(questionText);
    }

    public ShortAnswer(String questionText, int minLen){
        super(questionText);
        this.setMinLen(minLen);
    }

    public ShortAnswer(String questionText, int minLen, int maxLen){
        super(questionText);
        this.setMinLen(minLen);
        this.setMaxLen(maxLen);
    }
    //endregion


    /**
     * @param value - the answer the quiz-taker provides
     * @return true if set; false otherwise
     */
    private boolean meetsRequirements(String value){

        if(value.trim().length() >= minLen) //ensure that the value meets required minimum length
        {
            if(hasMaxLen){  //max length hook
                if(value.trim().length() <= maxLen){    //ensure that the value meets maximum length requirement
                    return true;
                }
            }
            else{
                return true;
            }
        }
        return true;
    }

    /**
     * @param len - minimum length proposed for an answer value. Must be non-negative.
     * @return true if the minimum length has been set; false otherwise
     */
    public boolean setMinLen(int len){
        if(len >= 0)    //ensure that the proposed length is non-negative. Can't have a negative number of characters.
        {
            this.minLen = len;
            return true;
        }
        return false;
    }

    /**
     * @param len - the maximum length of an answer value
     * @return true if the max length was set; false otherwise
     */
    public boolean setMaxLen(int len){
        if(this.minLen<=maxLen){ //ensure that the minLen is less than the max len
            this.hasMaxLen = true;
            this.maxLen = len;
            return true;
        }
        return false;
    }

    /**
     * Removes the max length restraint
     * @return false - this is the value of the variable that acts as a hook
     */
    public boolean unsetMaxLen()
    {
        this.hasMaxLen = false;
        return false;
    }

    /**
     * Indicates if max length restraint is present for this answer
     * @return true if max length restraint is set; false otherwise
     */
    public boolean hasMaxLen(){
        return this.hasMaxLen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {
        return Status.NEUTRAL;
    }


    /**
     * @param a - the user input, checks if the format of this answer is valid
     * @return true if valid; false otherwise
     */
    @Override
    protected boolean isValidUserAnswer(Answer a) {
        return this.meetsRequirements(a.getAnswer());
    }

}
