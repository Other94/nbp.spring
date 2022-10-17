package pl.example.nbp.service;


import com.google.gson.Gson;
import pl.example.nbp.model.Rate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DownloadUsd {

    private static final String NBP_API_URL = "http://api.nbp.pl/api/exchangerates/rates/a/usd/";
    private static String jsonUrl;




    public  void downloadUsdRate( int week) throws IOException {

        LocalDate date = LocalDate.parse("2022-10-17");

        ArrayList<LocalDate> localDateList = new ArrayList<>();

        for (int i = 0;i<week; i++ ){

            localDateList.add(date.plusDays(i+1));
            localDateList.add(date.plusDays(2));
            localDateList.add(date.plusDays(3));
            localDateList.add(date.plusDays(4));
            localDateList.add(date.plusDays(5));
            date.plusDays(6);
            date.plusDays(7);

        }
        localDateList.forEach(System.out::println);
//        jsonUrl = NBP_API_URL +  simpleDateFormat.format(date);
//        URL url = new URL(jsonUrl);
//        InputStreamReader reader = new InputStreamReader(url.openStream());
//
//        Rate rate = new Gson().fromJson(reader, Rate.class);
//
//        return usdRate;

    }



    public double downloadUsdRate(String date, double price) throws IOException {

        double exchangedRate;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        String formatDate = dateTimeFormatter.format(localDate);

        jsonUrl = NBP_API_URL + formatDate;
        URL url = new URL(jsonUrl);
        InputStreamReader reader = new InputStreamReader(url.openStream());

        Rate rate = new Gson().fromJson(reader, Rate.class);
        exchangedRate = rate.getRates().get(0).getMid() * price;

        return exchangedRate;
    }
}

