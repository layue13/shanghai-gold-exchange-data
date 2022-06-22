package com.example.shanghaigoldexchangedata.dao.impl;

import com.example.shanghaigoldexchangedata.dao.CandleMapper;
import com.example.shanghaigoldexchangedata.dao.dataprovider.CSVDataProvider;
import com.example.shanghaigoldexchangedata.model.Candle;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class CandleMapperCSVImpl implements CandleMapper {
    @Override
    public List<Candle> getCandlesByContract(String contract) {
        CsvReader data = CSVDataProvider.getCSVDataByFileName(contract);
        Stream<CsvRow> csvRowStream = data.stream();
        List<Candle> candles = csvRowStream
                .skip(1)
                .map(row->Candle.builder()
                        .date(row.getField(0))
                        .open(Double.parseDouble(row.getField(1)))
                        .close(Double.parseDouble(row.getField(2)))
                        .high(Double.parseDouble(row.getField(3)))
                        .low(Double.parseDouble(row.getField(4)))
                        .build())
                .onClose(()-> {
                    try {
                        data.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        csvRowStream.close();
        return candles;
    }
}
