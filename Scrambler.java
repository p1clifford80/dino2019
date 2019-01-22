
/**
 * Write a description of class Scrambler here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Scrambler extends Words
{

    public Scrambler()
    {
        super();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String challenge(String someText)
    {
        String answer = "";
        int index;
        // for(index = someText.length()-1 ; index>-1; index--)
        // {
            // answer = answer.concat(someText.substring(index, index+1));
        // }
        answer = "";
        for(int i = 0; i<someText.length(); i++)
        {
            int letIndex = (someText.length()-i)-1;
            answer += someText.substring(letIndex, letIndex+1);
        }
        return answer;   
    }
}
