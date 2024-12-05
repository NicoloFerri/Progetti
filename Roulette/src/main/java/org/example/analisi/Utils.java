package org.example.analisi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);


    public static void populateMap(LinkedHashMap<Integer, Description> mapOfNumbers) {
        mapOfNumbers.put(0, new Description("Green", null, null, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(32, new Description("Red", 2, 3, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(15, new Description("Black", 1, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(19, new Description("Red", 2, 2, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(4, new Description("Black", 1, 3, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(21, new Description("Red", 2, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(2, new Description("Black", 1, 2, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(25, new Description("Red", 3, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(17, new Description("Black", 2, 2, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(34, new Description("Red", 3, 3, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(6, new Description("Black", 1, 3, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(27, new Description("Red", 3, 1, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(13, new Description("Black", 2, 1, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(36, new Description("Red", 3, 3, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(11, new Description("Black", 2, 1, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(30, new Description("Red", 3, 2, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(8, new Description("Black", 1, 3, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(23, new Description("Red", 3, 2, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(10, new Description("Black", 1, 2, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(5, new Description("Red", 1, 1, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(24, new Description("Black", 3, 3, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(16, new Description("Red", 2, 2, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(33, new Description("Black", 3, 3, TypeEnum.SERIE_5_8.getType()));
        mapOfNumbers.put(1, new Description("Red", 1, 1, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(20, new Description("Black", 2, 1, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(14, new Description("Red", 2, 3, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(31, new Description("Black", 3, 2, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(9, new Description("Red", 1, 2, TypeEnum.ORFANELLI.getType()));
        mapOfNumbers.put(22, new Description("Black", 3, 2, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(18, new Description("Red", 2, 2, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(29, new Description("Black", 3, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(7, new Description("Red", 1, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(28, new Description("Black", 3, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(12, new Description("Red", 2, 1, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(35, new Description("Black", 3, 3, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(3, new Description("Red", 1, 3, TypeEnum.VICINI_DELLO_ZERO.getType()));
        mapOfNumbers.put(26, new Description("Black", 3, 2, TypeEnum.VICINI_DELLO_ZERO.getType()));
    }

    public static Report startBet(int numberOfIteration, HashMap<Integer,Double> betMaps , LinkedHashMap<Integer, Description> mapOfNumbers, Report report, Integer[] sequence){
        LOG.info("Start betting...");
        int stopLoss = -50;
        Double nPezziBettati = 0d;
        for(Map.Entry<Integer, Double> entry : betMaps.entrySet()){
            nPezziBettati=nPezziBettati+entry.getValue();
        }
        Double profitStart = report.getProfitto();
        Double netWon = 0d;
        int n;
        int x = report.getIterazione();
        for ( int i=0 ; i<numberOfIteration ; i++){
            n = sequence[x];
            x++;
            netWon=netWon-nPezziBettati;
            if(betMaps.get(n)!=null){
                netWon=netWon+(betMaps.get(n)*36);
            }
            //if(netWon>0 || netWon < stopLoss) break;
        }

        report.setIterazione(x);
        report.setProfitto(profitStart+netWon);
        return report;
    }

    public static Integer[] returnSequence (int duration){
        Integer[] seq = new Integer[duration];
        Random r = new Random();
        for(int i=0 ; i<seq.length ; i++){
            seq[i]=Generate.generateNumber(r);
        }
        return seq;
    }
}
