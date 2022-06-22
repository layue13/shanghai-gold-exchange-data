package com.example.shanghaigoldexchangedata.dao;

import com.example.shanghaigoldexchangedata.model.Candle;

import java.io.IOException;
import java.util.List;

public interface CandleMapper {
    List<Candle> getCandlesByContract(String contract);
}
