package com.softserve;

/**
 * Created by Olavin on 27.10.2014.
 */
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class MainSpring {
    private static void main(String[] args) {

/*
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Object bean = context.getBean("atm_networks_list");
        if(bean instanceof List){
            List<AtmNetwork> atmNetworks = (List<AtmNetwork>) bean;

            for(AtmNetwork network : atmNetworks){
                printAtmNetwork(network);
            }

            AtmNetworksXML.createXML(atmNetworks, "out/atm_networks.xml");
        }
*/

    }

    public static void printAtmNetwork(AtmNetwork network){
        System.out.println(network.getName());
        for(BankEntry bank : network.getBanks()){
            System.out.printf("  -  %s %s\n", bank.getBankName(), bank.getBankURL());
        }
        System.out.println();
    }

}
