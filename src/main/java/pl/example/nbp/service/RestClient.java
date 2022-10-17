package pl.example.nbp.service;


import com.google.gson.Gson;
import pl.example.nbp.model.Rate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RestClient {

    private static final String NBP_API_URL = "http://api.nbp.pl/api/exchangerates/rates/a/usd/";
    private static String jsonUrl;


    public double calculateUsdToPLN(Date date) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.format(date);
        System.out.println("dddd"+sdf.format(date));

        jsonUrl = NBP_API_URL +  sdf.format(date);
        URL url = new URL(jsonUrl);
        InputStreamReader reader = new InputStreamReader(url.openStream());

        Rate rate = new Gson().fromJson(reader, Rate.class);
        double usdRate = rate.getRates().get(0).getMid();

        return usdRate;
    }


    public double calculateUsdToPLN(String date, double price) throws IOException {

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

