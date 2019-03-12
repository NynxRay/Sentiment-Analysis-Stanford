package com.stanford_nlp.SentimentAnalyzer;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import java.io.FileWriter;
import java.io.PrintWriter;
import com.stanford_nlp.model.SentimentResult;

public class ApachePOIExcelRead {
	
	private static final String FILE_NAME = "textOutYP2.xlsx";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            PrintWriter writer = new PrintWriter("StanfordSentimentsYP2.txt", "UTF-8");
    		writer.println("Sentiment Score"+ ","+"Sentiment Type"+","+"Very positive"+","+"Positive"+","+"Neutral"+","+"Negative"+","+"Very negative");

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        String str = currentCell.getStringCellValue();
                        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        				sentimentAnalyzer.initialize();
        				SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(str);
        				
        				writer.println( sentimentResult.getSentimentScore()+ ","+
							    sentimentResult.getSentimentType()+ ","+
							    sentimentResult.getSentimentClass().getVeryPositive()+"%"+ ","+
						        sentimentResult.getSentimentClass().getPositive()+"%"+ ","+ 
						        sentimentResult.getSentimentClass().getNeutral()+"%"+ ","+
						        sentimentResult.getSentimentClass().getNegative()+"%"+ ","+
						        sentimentResult.getSentimentClass().getVeryNegative()+"%");
        				
        				
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        Double db = currentCell.getNumericCellValue();
                        String numberAsString = String.valueOf(db);
                        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        				sentimentAnalyzer.initialize();
        				SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(numberAsString);
        				
        				writer.println( sentimentResult.getSentimentScore()+ ","+
							    sentimentResult.getSentimentType()+ ","+
							    sentimentResult.getSentimentClass().getVeryPositive()+"%"+ ","+
						        sentimentResult.getSentimentClass().getPositive()+"%"+ ","+ 
						        sentimentResult.getSentimentClass().getNeutral()+"%"+ ","+
						        sentimentResult.getSentimentClass().getNegative()+"%"+ ","+
						        sentimentResult.getSentimentClass().getVeryNegative()+"%");
                    }

                }
                System.out.println();

            }
            
        writer.close();
        workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    

	}

}
