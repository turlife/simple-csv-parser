package com.simple.csvparser.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180ParserBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.simple.csvparser.bean.TransactionInputData;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionReader {


    public List<TransactionInputData> parse(String fileName) {
        return getCsvToBean(fileName).stream().collect(Collectors.toList());
    }

    private CsvToBean<TransactionInputData> getCsvToBean(String fileName) {
        return csvToBeanBuilder(fileName)
                .withType(TransactionInputData.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();
    }

    private CsvToBeanBuilder<TransactionInputData> csvToBeanBuilder(String fileName) {
        return new CsvToBeanBuilder(csvReader(fileName));
    }

    private CSVReader csvReader(String fileName) {
        return new CSVReaderBuilder(getReader(fileName))
                .withCSVParser(new RFC4180ParserBuilder().build())
                .build();
    }

    private InputStreamReader getReader(String fileName) {
        final InputStream resourceAsStream = TransactionReader.class.getClassLoader().getResourceAsStream(fileName);
        return new InputStreamReader(resourceAsStream);
    }

}
