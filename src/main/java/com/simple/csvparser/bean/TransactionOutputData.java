package com.simple.csvparser.bean;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;

public class TransactionOutputData {

    @CsvDate(value = "uuuu-MM-dd HH:mm:ss.n")
    @CsvBindByName
    public LocalDateTime created;

    @CsvBindByName
    public String uid;

    @CsvBindByName
    public String sku;

    @CsvBindByName
    public Double price;
}
