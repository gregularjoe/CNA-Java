package Java_2.Assignment3.RandomSentences;

import java.util.Random;

public class SentenceFactory {
    private final SentenceFragments sentenceFragments;
    private final Random rand;
    public SentenceFactory() {
        this.sentenceFragments = new SentenceFragments();
        this.rand = new Random();
    }

    public int getRandomNumber() {
        return this.rand.nextInt(5);
    }

    public String capitolizeWord(String firstWord) {
        return firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1);
    }

    public StringBuilder generateSentence() {

//              article, noun,verb, preposition, article and noun
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(capitolizeWord(sentenceFragments.getArticle()[getRandomNumber()]));
        stringBuilder.append(" ");
        stringBuilder.append(sentenceFragments.getNoun()[getRandomNumber()]);
        stringBuilder.append(" ");
        stringBuilder.append(sentenceFragments.getVerb()[getRandomNumber()]);
        stringBuilder.append(" ");
        stringBuilder.append(sentenceFragments.getPreposition()[getRandomNumber()]);
        stringBuilder.append(" ");
        stringBuilder.append(sentenceFragments.getArticle()[getRandomNumber()]);
        stringBuilder.append(" ");
        stringBuilder.append(sentenceFragments.getNoun()[getRandomNumber()]);
        stringBuilder.append(".");

        return stringBuilder;
    }
}
