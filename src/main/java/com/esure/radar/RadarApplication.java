package com.esure.radar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esure.radar.calculation.Calculation;

@SpringBootApplication
public class RadarApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(RadarApplication.class, args);

        Calculation calc = new Calculation();
    }
}
