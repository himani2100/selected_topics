package domain.Answers;

/**
 * An answer that holds a number value
 * @version 1
 */
public class NumericAnswer extends Answer{

    double value;                //the value that is being proposed as a response to a question
    double errorAcceptance = 0;  //allows for an answer to be considered equal within a margin above and bellow this answer

    //region constructor

    public NumericAnswer(float value){
        this.setValue(value);
    }

    public NumericAnswer(float value, float errorMargin){
        this.setValue(value);
        this.setErrorAcceptance(errorMargin);
    }
    //endregion

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAnswer() {
        return ""+this.value+"";
    }

    /**
     * Override of original Equals to account for margin of error
     * @param a - The answer to check against
     * @return true if equal; false otherwise
     */
   @Override
    public boolean Equals(Answer a) {

        try{
            NumericAnswer casted = (NumericAnswer) a;
            return isWithinErrorAcceptance(casted);
        } catch (Exception e) {
            e.printStackTrace();
            return super.Equals(a);
        }

    }

    /**
     * Attempts to modify internal variable "value". This can only be used in constructor. To change an answer value, you must create a new answer.
     * @param num - value to be used to update "value"
     * @return this.value
     */
    private double setValue(double num){
        this.value = num;
        return this.value;
    }

    /**
     * Gets the value that represents this answer
     * @return this.value
     */
    public double getValue(){
        return this.value;
    }

    /**
     * This function indicates if the value in "a" is within the margin of error as set by quiz creator
     * @param a - the value to check against
     * @return true if a is within the margin of error, false otherwise
     */
    private boolean isWithinErrorAcceptance(NumericAnswer a){
        return (a.getValue() <= (this.value+this.errorAcceptance)) && (a.getValue() >= (this.value-this.errorAcceptance));
    }

    /**
     * @return the margin of error that is acceptable between answers to consider them equal
     */
    public double getErrorMargin(){
        return this.errorAcceptance;
    }

    /**
     *
     * @param error - the difference between the this value and another so that they could be considered equal
     * @return this.errorAcceptance
     */
    public double setErrorAcceptance(double error){
        this.errorAcceptance = error;
        return this.errorAcceptance;
    }
}
