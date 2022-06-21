package com.example.shanghaigoldexchangedata.service;

import com.example.shanghaigoldexchangedata.model.TradeInfo;

import java.util.List;

public interface TradeInfoService {
    List<TradeInfo> getAllTradeInfo();

    List<String> getAllContract();

    List<TradeInfo> getTradeInfoByContract(String contract);

    List<String> getSortedDate();
}
