package org.aitools.programd.test.aiml;

/**
 * Tests whether a given input equals an expected string.
 * 
 * @author Albertas Mickensas
 */
public class AnswerChecker extends Checker
{
    private String expectedAnswer = null;

    /**
     * Creates a new AnswerChecked with the given expected answer.
     * 
     * @param answer the expected answer
     */
    public AnswerChecker(String answer)
    {
        this.expectedAnswer = answer;
    }

    /**
     * Tests whether the given input matches the expected answer.
     * 
     * @param input the input to test
     * @return whether the given input matches the expected answer
     * @see org.aitools.programd.test.aiml.Checker#test(java.lang.String)
     */
    public boolean test(String input)
    {
        if (null != this.expectedAnswer)
        {
            if (input.equals(this.expectedAnswer))
            {
                return true;
            }
            // otherwise...
            return false;
        }
        // otherwise...
        return false;
    }

}
