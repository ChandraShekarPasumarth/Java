package com.company;

import java.util.List;

class EfficientDocument extends Document {

    private int numWords;  // The number of words in the document
    private int numSentences;  // The number of sentences in the document
    private int numSyllables;  // The number of syllables in the document

    public EfficientDocument(String text)
    {
        super(text);
        processText();
    }


    private boolean isWord(String tok)
    {
        return !(tok.indexOf("!") >=0 || tok.indexOf(".") >=0 || tok.indexOf("?")>=0);
    }

    private void processText()
    {

        List<String> tokens = getTokens("[!?.]+|[a-zA-Z]+");


        for(int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            this.numWords += isWord(token)?1:0;
            this.numSentences += isWord(token)?0:1;
            if(i == (tokens.size() - 1) && isWord(token)) {
                this.numSentences += 1;
            }
            this.numSyllables += countSyllables(token);
        }


    }

    @Override
    public int getNumSentences() {

        return this.numSentences;
    }
    @Override
    public int getNumWords() {

        return this.numWords;
    }

    @Override
    public int getNumSyllables() {

        return this.numSyllables;
    }

    public static void main(String[] args)
    {
        testCase(new EfficientDocument("This is a test.  How many???  "
                        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
                16, 13, 5);

        testCase(new EfficientDocument("Segue"), 2, 1, 1);
        testCase(new EfficientDocument("Sentence"), 2, 1, 1);
        testCase(new EfficientDocument("Sentences?!"), 3, 1, 1);
        testCase(new EfficientDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
                32, 15, 1);

    }


}