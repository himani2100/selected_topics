package domain.Answers;

/**
 * Represents an answer given in a long-text format. Usually these answers are subjective thus they are default to neutral status. Their status can be changed to incorrect or correct manually.
 * @version 1
 */
public class LongTextAnswer extends Answer{


    String value;   //the text response

    //region Constructor
    public LongTextAnswer(String response){
        this.value = response;
    }

    //endregion

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAnswer() {

        return ""+this.value+"";

    }





}
