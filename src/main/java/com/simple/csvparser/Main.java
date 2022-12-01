package com.simple.csvparser;

import com.simple.csvparser.bean.TransactionInputData;
import com.simple.csvparser.bean.TransactionOutputData;
import com.simple.csvparser.parser.TransactionReader;
import com.simple.csvparser.parser.TransactionWriter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Load data from the csv file");
        List<TransactionInputData> transactions = new TransactionReader().parse("sample/test.csv");

        System.out.println("Size: " + transactions.size());

        List<TransactionOutputData> updateList = transactions.stream()
                .filter(inputTransaction -> inputTransaction.created.isBefore(LocalDateTime.now()))
                .map(inputTransaction -> toOutputTransaction(inputTransaction))
                .collect(Collectors.toList());

        System.out.println("Updated list size: " + updateList.size());

        new TransactionWriter().write(updateList, "test2222.csv");
    }

    private static TransactionOutputData toOutputTransaction(TransactionInputData inputTransaction) {
        TransactionOutputData transactionOutputData = new TransactionOutputData();
        transactionOutputData.created = inputTransaction.created;
        transactionOutputData.sku = inputTransaction.sku;
        transactionOutputData.uid = inputTransaction.uid;
        transactionOutputData.price = 10.0;

        return transactionOutputData;
    }
}
