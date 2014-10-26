package com.softserve;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olavin on 20.10.2014.
 */
public class PrivatBanksListCreator extends BanksListCreator {
    //private String networkUrl;

    PrivatBanksListCreator(String networkUrl, String listSelector){
        super(networkUrl, listSelector);
    }

    @Override
    protected BankEntry getBank(Element element) {
        return null;
    }

    @Override
    public List<BankEntry> createBanksList(){
        List<BankEntry> privatBank = new ArrayList<BankEntry>(1);
        privatBank.add(new BankEntry("ПриватБанк",networkUrl)); // only for PrivatBank networkUrl == bankUrl
        return privatBank;
    }

}
