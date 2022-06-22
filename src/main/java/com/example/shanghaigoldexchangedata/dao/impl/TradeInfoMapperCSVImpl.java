package com.example.shanghaigoldexchangedata.dao.impl;

import com.example.shanghaigoldexchangedata.dao.TradeInfoMapper;
import com.example.shanghaigoldexchangedata.dao.dataprovider.CSVDataProvider;
import com.example.shanghaigoldexchangedata.model.TradeInfo;
import de.siegmar.fastcsv.reader.CsvReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class TradeInfoMapperCSVImpl implements TradeInfoMapper {
    @SneakyThrows
    @Override
    public List<TradeInfo> findAll() {
        CsvReader data = CSVDataProvider.getCSVDataByFileName("TransactionData");
        return data
                .stream()
                .skip(1)
                .map(row -> TradeInfo.builder()
                        .id(Integer.parseInt(row.getField(0)))
                        .time(row.getField(1))
                        .contract(row.getField(2))
                        .changePrice(Double.parseDouble(row.getField(3)))
                        .changeRate(Double.parseDouble(row.getField(4).split("%")[0]) * 0.01)
                        .VWAP(Double.parseDouble(row.getField(5)))
                        .amount(row.getField(6))
                        .price(row.getField(7))
                        .build())
                .onClose(() -> {
                    try {
                        data.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
