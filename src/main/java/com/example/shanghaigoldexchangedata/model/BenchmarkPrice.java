package com.example.shanghaigoldexchangedata.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BenchmarkPrice {
    private String transactionTime;
    private double morningPrice;
    private double eveningPrice;
}
