import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordMatch {
    private String secret;
    public WordMatch (String word) {
        secret = word;
    }
    public int scoreGuess (String guess) {
        int score = 0;
        for(int i = 0; i <= secret.length() - guess.length(); i++)
            if (secret.substring(i,i + guess.length()).equals(guess))
                score++;
        return score * guess.length() * guess.length();
    }
    public String findBetterGuess (String guess1,String guess2) {
        if (scoreGuess(guess1) > scoreGuess(guess2))
        {
            return guess1;
        }
        else if (scoreGuess(guess2) > scoreGuess(guess1))
        {
            return guess2;
        }
        else
        {
            if (guess1.compareTo(guess2) > 0)
            {
                return guess1;
            }
            else
            {
                return guess2;
            }
        }
    }
    public static int read() throws IOException
    {
        int points = 0;
        File f = new File(".idea/Guesses.txt");
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            WordMatch w = new WordMatch(s.next());
            points += w.scoreGuess(w.findBetterGuess(s.next(), s.next()));
        }
        return points;
    }
}

