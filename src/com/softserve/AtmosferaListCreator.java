package com.softserve;

import org.jsoup.nodes.Element;

/**
 * Created by Olavin on 26.10.2014.
 */
public class AtmosferaListCreator extends BanksListCreator {

    AtmosferaListCreator(String networkUrl, String listSelector) {
        super(networkUrl, listSelector);
    }

    @Override
    public BankEntry getBank(Element element) {
        Element  tmp = element.nextElementSibling();
        String   bankName = element.text();
        String   bankUrl = tmp.child(0).absUrl("href");
        //  System.out.println(bankName);
        //  System.out.println(url);
        return new BankEntry(bankName,bankUrl);
    }
}
