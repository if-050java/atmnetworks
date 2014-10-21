package com.softserve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Created by Olavin on 20.10.2014.
 */
public class AtmosferaBanksListCreator implements IBanksListCreator {
    private String networkUrl;

    AtmosferaBanksListCreator(String networkUrl){
        this.networkUrl = networkUrl;
    }

    public List<BankEntry> createBanksList() {
        // TODO: write method
        List<BankEntry> atmosferaBanks = new ArrayList<BankEntry>();
        try {
            Document doc = Jsoup.connect(networkUrl).get();
            //Elements table = doc.select("tr.tab_top");
            Elements rows = doc.select("tr.tab_top");
            Element title = rows.get(0);
            Element table_row = title.nextElementSibling();
            while ( table_row != null){
                Elements name = table_row.select("td.tab_line_mini");
                System.out.println(name.html());
                table_row = table_row.nextElementSibling();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return atmosferaBanks;
    }

    /*
    public List<BankEntry> createBanksList(){
        // TODO: write method
        List<BankEntry> atmosferaBanks = new ArrayList<BankEntry>();



        try {
            Document doc = Jsoup.connect(networkUrl).get();
            Elements table = doc.select("tbody");
            Elements rows = table.select("tr");
            Elements names = rows.select("td.tab_line_mini");
            Elements links = rows.select("td.a");

            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                Element row = rows.get(i);
                Element name = names.get(i);
                Element link = links.get(i);

                atmosferaBanks.add(new BankEntry(name.text(), link.attr("href")));
            }

        } catch (IOException e) {
        e.printStackTrace();
        }

        return null; // List!
    }
*/
}
