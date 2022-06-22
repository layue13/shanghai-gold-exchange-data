package com.example.shanghaigoldexchangedata.service;

import com.example.shanghaigoldexchangedata.model.Candle;

import java.util.List;

public interface CandleService {
    List<Candle> getCandlesByContract(String contract);
}
