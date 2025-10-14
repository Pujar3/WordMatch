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
            return guess1;
        if (guess1.compareTo(guess2) > 0) return guess1;
        return null;
    }
}

