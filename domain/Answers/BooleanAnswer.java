package domain.Answers;

/**
 * A type of answer that gives true or false as a response
 * @version 1
 */
public class BooleanAnswer extends Answer{

    boolean value;  //the user answer to the question

    //region constructor
    public BooleanAnswer(boolean value)
    {
        this.value = value;
    }
    //endregion

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAnswer() {
        return ""+value+"";
    }

}
