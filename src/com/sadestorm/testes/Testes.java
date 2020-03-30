package com.sadestorm.testes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sadestorm.model.Produto;


public class Testes {

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		

		/*

		    List<CadastroProdutos> pessoas = new ArrayList<>();
	        pessoas.add(new CadastroProdutos("01", "smith", "branco", "tenis", "t1s", "stock", "2"));
	        pessoas.add(new CadastroProdutos("adidas", "sbpt", "preto", "tenis", "t1s", "stock", "2"));
	      //  pessoas.add(new CadastroProdutos("Ana",25,"ana@dicasdejava.com.br"));

	        Writer writer = Files.newBufferedWriter(Paths.get("pessoas.csv"));
	        StatefulBeanToCsv<CadastroProdutos> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

	        beanToCsv.write(pessoas);

	        writer.flush();
	        writer.close();
	        
	        FileWriter fw = new FileWriter(file)
	       */
			
		

       //  linhas.add(new CadastroProdutos("adidas", "smith", "branco", "tenis", "t1s", "stock", "2"));

	}

}
