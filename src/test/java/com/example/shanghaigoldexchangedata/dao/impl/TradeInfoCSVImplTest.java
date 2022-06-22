package com.example.shanghaigoldexchangedata.dao.impl;

import com.example.shanghaigoldexchangedata.dao.TradeInfoMapper;
import org.junit.jupiter.api.Test;

class TradeInfoCSVImplTest {

    private final TradeInfoMapper tradeInfoMapper = new TradeInfoMapperCSVImpl();

    @Test
    void findAll() {
        tradeInfoMapper.findAll().forEach(System.out::println);
    }
}