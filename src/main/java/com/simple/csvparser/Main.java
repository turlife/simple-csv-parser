package com.simple.csvparser;

import com.simple.csvparser.bean.TransactionData;
import com.simple.csvparser.parser.TransactionExporter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Load data from the csv file");
        List<TransactionData> transactions = new TransactionExporter().parse("sample/test.csv");
        System.out.println("Size: " + transactions.size());



    }
}
