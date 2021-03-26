package domain.Answers;

/**
 * An answer of a word or a few words
 *
 * @version 1
 */
public class TermAnswer extends Answer {

    String value;                //the value that is being proposed as a response to a question
    String[] similarAcceptableTerms = {};  //allows for an answer to be considered equal to any of these terms. Ex: a value of "vegetation" may be considered similar to "greenery" so they would calculate as equals
    boolean normalize = true;

    //region constructor

    public TermAnswer(String value){
        this.value = value;
    }

    public TermAnswer(String value, boolean normalize){
        this.value = value;
        this.setNormalize(normalize);
    }

    public TermAnswer(String value, String[] similarAcceptableTerms){
        this.value = value;
        this.setSimilarAcceptableTerms(similarAcceptableTerms);
    }


    public TermAnswer(String value, String[] similarAcceptableTerms, boolean normalize){
        this.value = value;
        this.setSimilarAcceptableTerms(similarAcceptableTerms);
        this.setNormalize(normalize);
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
     * Override of parent Equals to account for acceptable similar terms
     * @param a - The answer to check against
     * @return true if equals; false otherwise
     */
    @Override
    public boolean Equals(Answer a) {

        try{
            return isAcceptableTerm(a.getAnswer());
        } catch (Exception e) {
            e.printStackTrace();
            return super.Equals(a);
        }

    }


    /**
     * Gets the value that represents this answer
     * @return this.value
     */
    public String getValue(){
        return this.value;
    }

    /**
     * @param acceptableTerms - value to update list of acceptable terms with
     * @return this.similarAcceptableTerms
     */
    public String[] setSimilarAcceptableTerms(String[] acceptableTerms){
        this.similarAcceptableTerms = acceptableTerms;
        return this.similarAcceptableTerms;
    }

    /**
     * @return list of terms that have been identified as similar and acceptable comparable terms
     */
    public String[] getSimilarAcceptableTerms(){
        return this.similarAcceptableTerms;
    }

    /**
     * This function trims terms and sets all characters to upper case
     * @param string - the string to be normalized
     * @return normalized string
     */
    private String normalize(String string){

        if(this.normalize){
            string = string.trim().toUpperCase();
        }
        return string;
    }

    /**
     * Checks if the input term is comparable to the value of this answer
     * @param term - term to be checked if valid
     * @return true if term is valid; false otherwise
     */
    private boolean isAcceptableTerm(String term){

        String normalTerm = this.normalize(term);
        String thisNormalTerm = this.normalize(this.value);

        //check if term is similar to value
        if(thisNormalTerm.equals(term))
        {
            return true;
        }

        //check if term is similar to any acceptable terms
        for(String val : this.similarAcceptableTerms){
            if(val.equals(normalTerm))
            {
                return true;
            }
        }
        return false;   //no matches
    }

    /**
     * If normalize is set it indicates that values should be judged irregardless of case and space before or after.
     * @return true if normalize is set; false otherwise
     *
     */
    public boolean isNormalized(){
        return this.normalize;
    }

    /**
     * terms are compared in a normalized manner depending on isNormal
     * @param isNormal - indicates if terms should be normalized before comparison
     * @return true if terms should be normalized; false otherwise
     */
    public boolean setNormalize(boolean isNormal){
        this.normalize = isNormal;
        return this.normalize;
    }

}
