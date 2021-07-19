package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Document {

    private String text;

    protected Document(String text)
    {
        this.text = text;
    }


    protected List<String> getTokens(String pattern)
    {
        ArrayList<String> tokens = new ArrayList<String>();
        Pattern tokSplitter = Pattern.compile(pattern);
        Matcher m = tokSplitter.matcher(text);

        while (m.find()) {
            tokens.add(m.group());
        }

        return tokens;
    }


    protected int countSyllables(String word)
    {
        char[] chars = word.toCharArray();
        int syllablesCount = 0;

        boolean lastCharIsVowel = false;
        for(int i = 0; i < chars.length; i++) {
            char charInWord = chars[i];

            boolean found = isVowel(charInWord);

            if (found && !lastCharIsVowel ) {
                syllablesCount += 1;
                lastCharIsVowel = true;

            } else if(found) {
                lastCharIsVowel = true;
            } else {
                lastCharIsVowel = false;
            }


        }
        if( Character.toLowerCase(chars[chars.length-1]) == 'e' &&
                !isVowel(chars[chars.length-2])
                && syllablesCount > 1) {
            syllablesCount -= 1;
        }

        return syllablesCount;
    }

    private boolean isVowel(char c) {
        boolean found = false;
        char[] vowels = {'a', 'i', 'u', 'e', 'o', 'y'};
        for(char vowel: vowels) {
            if (Character.toLowerCase(c) == vowel) {
                return true;
            }
        }
        return found;
    }

    public static boolean testCase(Document doc, int syllables, int words, int sentences)
    {
        System.out.println("Testing text: ");
        System.out.print(doc.getText() + "\n....");
        boolean passed = true;
        int syllFound = doc.getNumSyllables();
        int wordsFound = doc.getNumWords();
        int sentFound = doc.getNumSentences();
        if (syllFound != syllables) {
            System.out.println("\nIncorrect number of syllables.  Found " + syllFound
                    + ", expected " + syllables);
            passed = false;
        }
        if (wordsFound != words) {
            System.out.println("\nIncorrect number of words.  Found " + wordsFound
                    + ", expected " + words);
            passed = false;
        }
        if (sentFound != sentences) {
            System.out.println("\nIncorrect number of sentences.  Found " + sentFound
                    + ", expected " + sentences);
            passed = false;
        }

        if (passed) {
            System.out.println("passed.\n");
        }
        else {
            System.out.println("FAILED.\n");
        }
        return passed;
    }


    public abstract int getNumWords();
    public abstract int getNumSentences();
    public abstract int getNumSyllables();
    public String getText()
    {
        return this.text;
    }
    public double getFleschScore()
    {
        double fleschScore = 206.835 - (1.015 * ((double)getNumWords()/ (double)getNumSentences())) - (84.6 * ((double)getNumSyllables() / (double)getNumWords()));
        return fleschScore;
    }



}