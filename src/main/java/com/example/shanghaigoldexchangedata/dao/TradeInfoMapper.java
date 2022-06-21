package com.example.shanghaigoldexchangedata.dao;

import com.example.shanghaigoldexchangedata.model.TradeInfo;

import java.util.List;

public interface TradeInfoMapper {
    List<TradeInfo> findAll();
}
