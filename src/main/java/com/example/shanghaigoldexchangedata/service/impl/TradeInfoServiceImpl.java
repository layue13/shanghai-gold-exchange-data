package com.example.shanghaigoldexchangedata.service.impl;

import com.example.shanghaigoldexchangedata.dao.TradeInfoMapper;
import com.example.shanghaigoldexchangedata.model.TradeInfo;
import com.example.shanghaigoldexchangedata.service.TradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeInfoServiceImpl implements TradeInfoService {
    private TradeInfoMapper tradeInfoMapper;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    public void setTradeInfoMapper(TradeInfoMapper tradeInfoMapper) {
        this.tradeInfoMapper = tradeInfoMapper;
    }

    @Override
    public List<TradeInfo> getAllTradeInfo() {
        return Collections.unmodifiableList(tradeInfoMapper.findAll());
    }

    @Override
    public List<String> getAllContract() {
        return tradeInfoMapper.findAll()
                .stream()
                .map(TradeInfo::getContract)
                .distinct()
                .toList();
    }

    @Override
    public List<TradeInfo> getTradeInfoByContract(String contract) {
        return tradeInfoMapper.findAll().stream()
                .filter(tradeInfo -> tradeInfo.getContract().equals(contract)).toList();
    }

    @Override
    public List<String> getSortedDate() {
        return tradeInfoMapper.findAll().stream()
                .map(TradeInfo::getTime)
                .distinct()
                .sorted((s, t1) -> {
                    try {
                        return sdf.parse(s).compareTo(sdf.parse(t1));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
