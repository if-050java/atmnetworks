package com.softserve;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Olavin on 26.10.2014.
 */
public class UbanksComListCreator extends BanksListCreator {
    UbanksComListCreator(String networkUrl, String listSelector) {
        super(networkUrl, listSelector);
    }

    public BankEntry getBank(Element element){
        String bankName;
        String bankUrl;
        if(element.children().isEmpty()){
            bankName = element.text();
            // no site URL for this Bank :(
            bankUrl = "";
            // trying to search at Google
            //bankUrl = GoogleSearch.find(bankName); //trying to search at Google
        } else {
            // lookup for Bank's site URL on separate page
            bankName = element.child(0).text();
            bankUrl = searchBankSite(element.child(0).attr("href"));
        }
        //System.out.printf("{%d} ",i++);
        //System.out.println(bankName+";"+bankUrl);
        return new BankEntry(bankName, bankUrl);

    }

    private String searchBankSite(String pageUrl) {
        String bankAddr = "";
        Document doc = null;
        try {
            URL baseUrl = new URL(networkUrl);
            URL url = new URL(baseUrl,pageUrl);
            doc = Jsoup.connect(url.toString()).get();
        } catch (IOException e) {
            return bankAddr;
        }
        Elements elements = doc.select("div.url>span.value-title"); // '>' means "sub" select
        bankAddr = elements.get(0).child(0).attr("href");
        return bankAddr;
    }

}
