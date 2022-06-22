package com.example.shanghaigoldexchangedata.service.impl;

import com.example.shanghaigoldexchangedata.dao.CandleMapper;
import com.example.shanghaigoldexchangedata.model.Candle;
import com.example.shanghaigoldexchangedata.service.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
public class CandleServiceImpl implements CandleService {
    private CandleMapper candleMapper;

    @Autowired
    public void setCandleMapper(CandleMapper candleMapper) {
        this.candleMapper = candleMapper;
    }

    @Override
    public List<Candle> getCandlesByContract(String contract) {
        return candleMapper.getCandlesByContract(contract);
    }
}
