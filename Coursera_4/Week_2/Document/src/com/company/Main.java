package com.company;

import java.util.List;
class BasicDocument extends Document
{
    public BasicDocument(String text)
    {
        super(text);
    }

    @Override
    public int getNumWords()
    {
        List<String> tokens = super.getTokens("[a-zA-Z]+");
        return tokens.size();
    }

    @Override
    public int getNumSentences()
    {
        List<String> tokens = super.getTokens("[(),1-9a-zA-Z ]+[\\.|!|\\?]*");
        return tokens.size();
    }

    @Override
    public int getNumSyllables()
    {
        List<String> tokens = super.getTokens("[a-zA-Z]+");
        int syllablesCount = 0;
        for(String word: tokens) {
            syllablesCount += super.countSyllables(word); }
        return syllablesCount ;
    }

    public static void main(String[] args)
    {

        testCase(new BasicDocument(""), 0, 0, 0);
        testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
        testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
        testCase(new BasicDocument("Sentence"), 2, 1, 1);
        testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
                32, 15, 1);



    }

}
