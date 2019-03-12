package com.interviewBubble.sentimentanalysis;

public class SentimentAnalysis {

 public static void main(String[] args) {

     // I have taken iPhone X (Silver) User Review from Amazon

     String text = "Just love the X. Feel so Premium and a Head turner too. Face ID working fine but still miss "

       + "the fingerprint scanner very much. I jump from 5S to X so it¡¯s a huge skip. I¡¯m very very happy"

       + " with it. Specially battery backup is great after using with 4g cellular network and no heating "

       + "issue at all, though I¡¯m not a mobile gamer, Oftentimes I play Boom Beach and I watch YouTube "

       + "videos and I surf a lot. It makes a deep hole in pocket at the Hefty price tag. So it¡¯s all "

       + "upto your Consideration.\n";

     SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();

     sentimentAnalyzer.initialize();

     SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);

     

     System.out.println("Sentiments Classification:");

  System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");

  System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");

  System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");

  System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");

  System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");

     System.out.println("\nSentiments result:");

     System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());

  System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());

 }

}