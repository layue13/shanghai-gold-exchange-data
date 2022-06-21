package com.example.shanghaigoldexchangedata.model;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TradeInfo {
    private int id;
    private String time;
    private String contract;
    private double changePrice;
    private double changeRate;
    private double VWAP;
    private String amount;
    private String price;
}
