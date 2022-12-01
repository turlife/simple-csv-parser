package com.simple.csvparser.parser;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.simple.csvparser.bean.TransactionOutputData;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class TransactionWriter {

    public void write(List<TransactionOutputData> transactions, String fileName) throws Exception {
        String path = TransactionReader.class.getClassLoader().getResource("sample").getPath();

        try (Writer writer = new FileWriter(path + File.separator + fileName)) {

            StatefulBeanToCsv<TransactionOutputData> sbc = new StatefulBeanToCsvBuilder<TransactionOutputData>(writer)
                    .withQuotechar('\"')
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            sbc.write(transactions);
        }
    }
}
