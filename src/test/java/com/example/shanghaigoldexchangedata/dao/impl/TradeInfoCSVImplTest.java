package com.example.shanghaigoldexchangedata.dao.impl;

import com.example.shanghaigoldexchangedata.dao.TradeInfoMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TradeInfoCSVImplTest {

    private final TradeInfoMapper tradeInfoMapper = new TradeInfoCSVImpl();

    @Test
    void findAll() {
        tradeInfoMapper.findAll().forEach(System.out::println);
    }
}