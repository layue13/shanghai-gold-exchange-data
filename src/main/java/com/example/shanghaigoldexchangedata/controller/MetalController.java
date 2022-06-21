package com.example.shanghaigoldexchangedata.controller;

import com.example.shanghaigoldexchangedata.ResponseWrapper;
import com.example.shanghaigoldexchangedata.model.TradeInfo;
import com.example.shanghaigoldexchangedata.service.TradeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("metal")
@CrossOrigin(
        allowedHeaders = {"*"},
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS},
        origins = {"*"}
)
@Slf4j
public class MetalController {

    private TradeInfoService tradeInfoService;

    @Autowired
    public void setTradeInfoService(TradeInfoService tradeInfoService) {
        this.tradeInfoService = tradeInfoService;
    }

    @GetMapping("tradeInfo")
    public ResponseWrapper<List<TradeInfo>> getTradeInfo(String contract) {
        log.info(contract);
        if (contract == null) {
            return new ResponseWrapper<>("200", tradeInfoService.getAllTradeInfo());
        }
        return new ResponseWrapper<>("200", tradeInfoService.getTradeInfoByContract(contract));
    }

    @GetMapping("tradeContract")
    public ResponseWrapper<List<String>> getTradeContract() {
        return new ResponseWrapper<>("200", tradeInfoService.getAllContract());
    }

    @GetMapping("getSortedDate")
    public ResponseWrapper<List<String>> getSortedDate(){
        return new ResponseWrapper<>("200",tradeInfoService.getSortedDate());
    }


}
