package domain.Answers;

/**
 * Answers can be incorrect, correct, or, it is possible that an question does not elicit correct or incorrect response. In this case, the status of an answer in neutral.
 * It is also possible that an answer has not yet been graded, in this case the answer status is "pending". An answers default state is also pending.
 * EX: A question may be, "2+2=?". This question has 2 clear correct answers: incorrect (!4) and correct (4).
 * EX: A question like, "What is your favourite colour?", does not have a clear answer as the question is subjective.
 * @version 1
 */
public enum Status {
    CORRECT,
    INCORRECT,
    NEUTRAL,
    PENDING
}
