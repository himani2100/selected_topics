package domain.Quizzes;

import domain.Answers.Answer;
import domain.Questions.Question;
import domain.Results.Results;


/**
 * A quiz is a list of questions that yields results based on the way questions are answered
 * @version 1.1
 */
public abstract class Quiz {

    protected Question[] questions; //the questions associated with this quiz
    int numberOfQuestions = 0;      //indicates the number of questions in this quiz, is dependant on this.questions
    boolean isRandom = false;       //hook that indicates if questions should be served random(true) or ordered(false).
    Results results;                //indicates the type of results returned by this quiz

    //region constructor
    public Quiz(Results result, Question[] questions){
        this.setResults(result);
        this.setQuestions(questions);
    }
    //endregion

    //region getters
    /**
     * Gets the question based on the id entered
     * @param questionId - the id of the question to return
     * @return Question with id of questionId
     */
    public void getQuestion(int questionId){
        System.out.println("Gets question with id "+questionId);
    }

    /**
     * Gets a list of all questions in this quiz
     * @return an array of all questions in quiz
     * This method depends on {@link #getQuestion(int)}
     */
    public void getQuestions(){
        System.out.println("Gets an array of all question");
    }

    /**
     * Gets the text of a specified question
     * @param questionId - the id of the question to get text of
     * @return the question in plain-text
     * This method depends on {@link #getQuestion(int)}
     */
    public void getQuestionText(int questionId){
        System.out.println("Gets question text of question with id "+questionId);
    }


    /**
     * Gets a list of all questions in this quiz, formatted in plain-text
     * @return a list of plain-text questions
     * This method depends on {@link #getQuestionText(int)}
     */
    public void getQuestionsText(){
        System.out.println("returns a list of questionTexts");
    }

    /**
     * Indicates the number of questions in this quiz
     * @return the number of questions in this quiz
     */
    public void getSize(){
        System.out.println("The size of this quiz is "+ this.numberOfQuestions);
    }

    /**
     * Indicates if the questions in this quiz are served in a random or uniform order
     */
    public void isRandomOrder(){
        System.out.println("The questions are served randomly: "+this.isRandom);

    }
    //endregion

    //region setters
    /**
     * Sets this.questions if format is valid
     * @param questions - the questions to apply to this quiz
     * @return the list of questions applied to this quiz
     * This method depends on {@link #setQuestion(Question)}
     */
    protected void setQuestions(Question[] questions){
        System.out.println("cycles through questions and tries to set each question. If they are set they are added to a list of set questions. This list is returned");
        System.out.println("Calls setQuestion(Question question)");
    }


    /**
     * Attempt add question to this quiz
     * @param question - the question to try to set
     * @return true if set; false otherwise
     * This method depends on {@link #isValidQuestion(Question)}
     */
    protected void setQuestion(Question question){
        System.out.println("Attempts to add question to this quiz");
        System.out.println("Calls isValidQuestion(Question question)");
    }

    /**
     * Sets a hook that indicates if questions should be served in a random or ordered fashion
     * @param isRandomized - the hook. True => order is random. False => order is ordered by index
     * @returns true if order is randomized; false otherwise
     */
    public void setToRandomizeQuestionOrder(boolean isRandomized){
        System.out.println("Indicates if questions should be served in a random or ordered fashion");
    }

    /**
     * Sets this. results
     * @param results - the type of results to be returned by the quiz
     * @return the value of this.results
     */
    private void setResults(Results results){
        this.results = results;
    }
    //endregion


    //region Validators

    /**
     * Checks if a question is in a valid format
     * @param question - the question to examine
     * @result return true if valid; false otherwise
     */
    protected void isValidQuestion(Question question){

    }

    //endregion

    //region Behaviour

    /**
     * Takes a list of questions and returns an array with the question in a different order
     * @param questions - the list to re-organize
     * @return a new array with questions in a different order
     */
    private void randomizeQuestionOrder(Question[] questions){
        System.out.println("Questions Randomized");

    }

    /**
     * Gets the current results for a quiz
     * @return formatted quiz results
     */
    public void getResults() {
        this.results.getResults();
    }
    /**
     * Gets results of the question associated with this id
     * @param id - the id of the question
     * This method calls {@link #updateResults()} and {@link Results#getResults()}
     */
    public void getQuestionResults(int id){
        this.updateResults();
        this.results.getResults();
    }

    /**
     * Sets an answer to a question
     * @param id - the id of the question to answer
     * @param answer - the answer given by the user
     */
    public void answerQuestion(int id, Answer answer){

    }

    /**
     * Updates results
     */
    public abstract void updateResults();
    //endregion



}
