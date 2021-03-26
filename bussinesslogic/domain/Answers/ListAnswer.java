package domain.Answers;

/**
 * A type of answer in the form of a list of objects
 * @version 1
 */
public class ListAnswer extends Answer{

    Object[] list;  //list that is being referred to

    public ListAnswer(Object[] list){
        this.list = list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAnswer() {
        StringBuilder s = new StringBuilder("[ ");

        for(Object o : list){
            s.append("'").append(o.toString()).append("' ");
        }

        s.append(" ]");
        return s.toString();
    }
}
