package com.stanford_nlp.SentimentAnalyzer;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.stanford_nlp.model.SentimentResult;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String line = null;
		PrintWriter writer = new PrintWriter("StanfordSentimentsTest.txt", "UTF-8");
		writer.println("Sentiment Score"+ ","+"Sentiment Type"+","+"Very positive"+","+"Positive"+","+"Neutral"+","+"Negative"+","+"Very negative");
		int n= 0;
		while ((line = br.readLine()) != null) {
		   String[] values = line.split("\n");

		   for (String str : values) {
		        System.out.println(str);
			   
			   
			    SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
				sentimentAnalyzer.initialize();
				SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(str);
				
				System.out.println(n);
				n++;
				writer.println( sentimentResult.getSentimentScore()+ ","+
							    sentimentResult.getSentimentType()+ ","+
							    sentimentResult.getSentimentClass().getVeryPositive()+"%"+ ","+
						        sentimentResult.getSentimentClass().getPositive()+"%"+ ","+ 
						        sentimentResult.getSentimentClass().getNeutral()+"%"+ ","+
						        sentimentResult.getSentimentClass().getNegative()+"%"+ ","+
						        sentimentResult.getSentimentClass().getVeryNegative()+"%");
				
				
				
			   
		      }  
		    }
		writer.close();
		br.close(); 
		
		  
		
		
		//ApachePOIExcelRead.main(args);
		

	}

}
