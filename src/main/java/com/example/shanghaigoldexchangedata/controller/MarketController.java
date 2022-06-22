package com.example.shanghaigoldexchangedata.controller;

import com.example.shanghaigoldexchangedata.ResponseWrapper;
import com.example.shanghaigoldexchangedata.dao.CandleMapper;
import com.example.shanghaigoldexchangedata.model.Candle;
import com.example.shanghaigoldexchangedata.service.CandleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("market")
@CrossOrigin(
        allowedHeaders = {"*"},
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS},
        origins = {"*"}
)
@Slf4j
public class MarketController {
    private CandleService candleService;

    @Autowired
    public void setCandleService(CandleService candleService) {
        this.candleService = candleService;
    }

    @GetMapping("candles")
    public ResponseWrapper<List<Candle>> getCandle(String contract) {
        if (contract == null) {
            return new ResponseWrapper<>("418", null);
        }
        log.info(contract);
        return new ResponseWrapper<>("200", candleService.getCandlesByContract(contract));
    }
}
