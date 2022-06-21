package com.example.shanghaigoldexchangedata.dao.impl;

import com.example.shanghaigoldexchangedata.dao.TradeInfoMapper;
import com.example.shanghaigoldexchangedata.model.TradeInfo;
import de.siegmar.fastcsv.reader.CommentStrategy;
import de.siegmar.fastcsv.reader.CsvReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class TradeInfoCSVImpl implements TradeInfoMapper {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @SneakyThrows
    public TradeInfoCSVImpl() {
        log.info(URLDecoder.decode(this.getClass().getResource("/data/成交行情.csv").getFile(), StandardCharsets.UTF_8));
    }

    public CsvReader getCsvReaderForTradeInfoData() throws FileNotFoundException {
        return CsvReader.builder()
                .skipEmptyRows(true)
                .commentStrategy(CommentStrategy.SKIP)
                .errorOnDifferentFieldCount(true)
                .build(new FileReader(URLDecoder.decode(this.getClass().getResource("/data/成交行情.csv").getFile(), StandardCharsets.UTF_8)));
    }

    @SneakyThrows
    @Override
    public List<TradeInfo> findAll() {
        CsvReader data = getCsvReaderForTradeInfoData();
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
