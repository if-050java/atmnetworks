package com.softserve;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olavin on 26.10.2014.
 */
public abstract class BanksListCreator implements IBanksListCreator {
    protected String networkUrl;
    protected String listSelector;

    BanksListCreator(String networkUrl, String listSelector){
        this.networkUrl = networkUrl;
        this.listSelector = listSelector;
    }

    public abstract BankEntry getBank(Element element);

    @Override
    public List<BankEntry> createBanksList(){
        List<BankEntry> banksList = new ArrayList<BankEntry>();
        Document doc = null;
        try {
            doc = Jsoup.connect(networkUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements banks = doc.select(listSelector);
        for (Element element : banks) {
            banksList.add(getBank(element));
        }
        return banksList;
    }

}
