package com.softserve;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<AtmNetwork> atmNetworks = new ArrayList<AtmNetwork>(5); // 5 will be enough

        atmNetworks.add(new AtmNetwork("ПриватБанк", new PrivatBanksListCreator("https://privatbank.ua/")));
        atmNetworks.add(new AtmNetwork("АТМоСфера", new AtmosferaListCreator("http://www.atmosphere.net.ua/ru/members_atmoshera_rus.htm?print&showAll=1","td.tab_line_mini")));
        atmNetworks.add(new AtmNetwork("Euronet", new UbanksComListCreator("http://ubanks.com.ua/atmnet/euronet.php","#zmist li")));
        atmNetworks.add(new AtmNetwork("Радіус", new UbanksComListCreator("http://ubanks.com.ua/atmnet/radius.php","#zmist li")));
        atmNetworks.add(new AtmNetwork("УкрКард", new UbanksComListCreator("http://ubanks.com.ua/atmnet/ukrcard.php","#zmist li")));


        for(AtmNetwork network : atmNetworks){
            printAtmNetwork(network);
        }

        AtmNetworksXML.createXML(atmNetworks, "src/atm_networks.xml");

    }

    public static void printAtmNetwork(AtmNetwork network){
        System.out.println(network.getName());
        for(BankEntry bank : network.getBanks()){
            System.out.printf("  -  %s %s\n", bank.getBankName(), bank.getBankURL());
        }
        System.out.println();
    }
}
