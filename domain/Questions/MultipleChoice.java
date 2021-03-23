package domain.Questions;

import domain.Answers.Answer;
import domain.Answers.LongTextAnswer;
import domain.Answers.Status;

/**
 * A type of question that has several answers a user can selected from
 *
 * @version 1
 */
public class MultipleChoice extends Question {

    Answer[] answers;       //The list of answers a user can select from
    int correctIndex;       //The indices of the correct answers referring to the answers array

    //region Constructor
    public MultipleChoice(String questionText, int correctIndex, Answer[] answers) {
        super(questionText);
        this.answers = answers;
        this.setCorrectIndex(correctIndex);
    }

    public MultipleChoice(String questionText, int correctIndex, String[] answers) {
        super(questionText);
        this.answers = new Answer[answers.length];

        for(int i=0; i<answers.length; i++){
            this.answers[i] = new LongTextAnswer(answers[i]);

            if(i==correctIndex){
                this.answers[i].setStatus(Status.CORRECT);
            }else{
                this.answers[i].setStatus(Status.INCORRECT);
            }
        }

        this.setCorrectIndex(correctIndex);
    }
    //endregion

    /**
     * {@inheritDoc}
     */
    @Override
    protected Status getStatusBasedOn(Answer userAnswer) {
        int userAnswerInt = getUserAnswerAsInt();

        if(correctIndex == userAnswerInt){
            return Status.CORRECT;
        }
        return Status.INCORRECT;
    }

    /**
     * Sets the value of variable that indicates the index of the correct answer
     * @param index - the index of the correct answer
     * @return true if set; false otherwise
     */
    private boolean setCorrectIndex(int index){

        if(index>=0 && index < this.answers.length)
        {
            this.correctIndex = index;
            return true;
        }
        return false;
    }


    /**
     * Gets the answer option from this.answers according to the index. Returns the option in plain-text
     * @param index - the index of the option to get
     * @return The option in plain-text
     */
    public String getOption(int index){

        try{
            return answers[index].getAnswer();
        }catch(Exception e)
        {
            return "";
        }

    }

    /**
     * Gets the option that the user selected in plain-text
     * @return A string of user-selected options
     */
    public String getUserSelectedOption(){
        try{
            int index = this.getUserAnswerAsInt();
            return answers[index].getAnswer();
        }catch(Exception e)
        {
            return "";
        }
    }

    /**
     * Gets the option selected by the user as an integer index
     * @return a list of indices that refer to the index that
     */
    public int getUserSelectedIndex(){
        return this.getUserAnswerAsInt();
    }

    public String[] getOptions(){
        String[] textOptions = new String[this.answers.length];
        int i = 0;  //placeholder variable
        
        for(Answer a : this.answers){
            textOptions[i] = a.getAnswer();
            i++;
        }
        return textOptions;
    }

    /**
     * All answers return a String type when GetAnswer is called. This function parses the return from String to int so that it can be used as an index
     * @return an int representing a quiz-taker's answer
     */
    private int getUserAnswerAsInt(){
        int userAnswerInt = -1;
        try{
            userAnswerInt = Integer.parseInt( userAnswer.getAnswer().trim());

        }catch(NumberFormatException e){

            try{

                float userFloat = Float.parseFloat(userAnswer.getAnswer().trim());
                userAnswerInt = (int) userFloat;
            }catch(Exception exception)
            {
                return userAnswerInt;
            }

        }catch(Exception e){
            return userAnswerInt;
        }
        return userAnswerInt;
    }

}
