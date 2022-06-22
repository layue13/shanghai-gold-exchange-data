package com.example.shanghaigoldexchangedata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

class ShanghaiGoldExchangeDataApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(this.getClass().getResource("TransactionData.csv").getFile());
    }

}
