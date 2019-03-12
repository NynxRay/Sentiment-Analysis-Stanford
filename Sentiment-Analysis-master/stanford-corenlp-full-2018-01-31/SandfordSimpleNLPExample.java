package com.interviewbubble.StandfordSimpleNLP;

import java.util.Properties;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SandfordSimpleNLPExample{

    public static void main( String[] args ){

         // creates a StanfordCoreNLP object, with POS tagging, lemmatization,
        // NER, parsing, and coreference resolution
        Properties props = new Properties();

        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        String text = "She went to America last week.";

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        System.out.println( "End of Processing" );
    }
}