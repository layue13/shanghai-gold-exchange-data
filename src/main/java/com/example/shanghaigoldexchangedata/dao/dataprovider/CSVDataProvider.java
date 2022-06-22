package com.example.shanghaigoldexchangedata.dao.dataprovider;

import de.siegmar.fastcsv.reader.CommentStrategy;
import de.siegmar.fastcsv.reader.CsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CSVDataProvider {
    public static CsvReader getCSVDataByFileName(String filename){
        try {
            return CsvReader.builder()
                    .skipEmptyRows(true)
                    .commentStrategy(CommentStrategy.SKIP)
                    .errorOnDifferentFieldCount(true)
                    .build(new FileReader(CSVDataProvider.class.getResource("/data/"+filename+".csv").getFile()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
