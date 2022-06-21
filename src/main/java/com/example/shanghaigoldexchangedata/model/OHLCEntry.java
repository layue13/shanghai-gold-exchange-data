package com.example.shanghaigoldexchangedata.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OHLCEntry {
    private String date;
    private double open;
    private double close;
    private double high;
    private double low;
}
