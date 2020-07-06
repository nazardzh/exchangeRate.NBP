package org.example;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class App
{
    private static org.jsoup.nodes.Document getPage() throws IOException {
        String url = "https://www.nbp.pl/home.aspx?f=/kursy/kursya.html";
        Document page =  Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main( String[] args ) throws IOException {
        Document page = getPage();
        Elements tableCurrency = page.select("table[class=pad5]");
        Elements values = tableCurrency.select("tr");
        for(Element kurs : values){
            String currency = kurs.select("td.bgt2.right, td.bgt1.right" ).text();
            System.out.println(currency);
        }
    }
}
