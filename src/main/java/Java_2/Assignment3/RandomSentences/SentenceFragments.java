package Java_2.Assignment3.RandomSentences;

public class SentenceFragments {

    private String[] article;
    private String[] noun;
    private String[] preposition;
    private String[] verb;

    public SentenceFragments() {
        this.article = new String[] {"the", "a", "one", "any", "some"};
        this.noun = new String[] {"boy", "girl", "dog", "town", "car"};
        this.preposition = new String[] {"to", "from", "over", "under", "on"};
        this.verb = new String[] {"drove", "jumped", "ran", "walked", "skipped"};
    }

    public String[] getArticle() {
        return article;
    }

    public String[] getNoun() {
        return noun;
    }

    public String[] getPreposition() {
        return preposition;
    }

    public String[] getVerb() {
        return verb;
    }
}
