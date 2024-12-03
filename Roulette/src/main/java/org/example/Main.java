package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.*;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        int totalNumbers = 37;
        int numberOfIteration = 200;
        Random r = new Random();

        HashMap<String, Double> expectedMap = new HashMap<String, Double>();
        expectedMap.put(TypeEnum.ORFANELLI.getType(), ((8.0 / totalNumbers) * 100)); //21.62
        expectedMap.put(TypeEnum.SERIE_5_8.getType(), ((12.0 / totalNumbers) * 100)); //32.43
        expectedMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), ((17.0 / totalNumbers) * 100)); //45.94

        HashMap<String, Boolean> operatingMap = new HashMap<String, Boolean>();
        operatingMap.put(TypeEnum.ORFANELLI.getType(), false);
        operatingMap.put(TypeEnum.SERIE_5_8.getType(), false);
        operatingMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), false);

        HashMap<String, Double> gapMap = new HashMap<String, Double>();
        gapMap.put(TypeEnum.ORFANELLI.getType(), 0d);
        gapMap.put(TypeEnum.SERIE_5_8.getType(), 0d);
        gapMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), 0d);

        LOG.info("starting process.. ");
        LinkedList<String> rouletteNumbersList = new LinkedList<>(Arrays.asList("0", "32", "15", "19", "4", "21", "2", "25", "17", "34", "6", "27", "13", "36", "11", "30", "8", "23", "10", "5", "24", "16", "33", "1", "20", "14", "31", "9", "22", "18", "29", "7", "28", "12", "35", "3", "26"));

        HashMap<Integer,Double> orfanelliBetMaps = new HashMap<Integer,Double>();
        orfanelliBetMaps.put(1,1.0);
        orfanelliBetMaps.put(6,0.5);
        orfanelliBetMaps.put(9,0.5);
        orfanelliBetMaps.put(14,0.5);
        orfanelliBetMaps.put(17,0.5);
        orfanelliBetMaps.put(20,0.5);
        orfanelliBetMaps.put(31,0.5);
        orfanelliBetMaps.put(34,0.5);

        HashMap<Integer,Double> viciniDelloZeroBetMaps = new HashMap<>();
        viciniDelloZeroBetMaps.put(0,0.5);
        viciniDelloZeroBetMaps.put(2,0.5);
        viciniDelloZeroBetMaps.put(3,0.5);
        viciniDelloZeroBetMaps.put(4,0.5);
        viciniDelloZeroBetMaps.put(7,0.5);
        viciniDelloZeroBetMaps.put(12,0.5);
        viciniDelloZeroBetMaps.put(15,0.5);
        viciniDelloZeroBetMaps.put(18,0.5);
        viciniDelloZeroBetMaps.put(21,0.5);
        viciniDelloZeroBetMaps.put(19,0.5);
        viciniDelloZeroBetMaps.put(22,0.5);
        viciniDelloZeroBetMaps.put(25,0.5);
        viciniDelloZeroBetMaps.put(26,0.5);
        viciniDelloZeroBetMaps.put(28,0.5);
        viciniDelloZeroBetMaps.put(29,0.5);
        viciniDelloZeroBetMaps.put(32,0.5);
        viciniDelloZeroBetMaps.put(35,0.5);

        HashMap<Integer,Double> SerieBetMaps = new HashMap<>();
        SerieBetMaps.put(5,0.5);
        SerieBetMaps.put(8,0.5);
        SerieBetMaps.put(11,0.5);
        SerieBetMaps.put(10,0.5);
        SerieBetMaps.put(13,0.5);
        SerieBetMaps.put(16,0.5);
        SerieBetMaps.put(23,0.5);
        SerieBetMaps.put(24,0.5);
        SerieBetMaps.put(27,0.5);
        SerieBetMaps.put(30,0.5);
        SerieBetMaps.put(32,0.5);
        SerieBetMaps.put(36,0.5);


        LinkedHashMap<Integer, Description> mapOfNumbers = new LinkedHashMap<Integer, Description>();
        populateMap(mapOfNumbers);
        Integer viciniDelloZeroInt = 0;
        Integer serie58Int = 0;
        Integer orfanelliInt = 0;

        int n;
        for (int i = 1; i < numberOfIteration; i++) {
            n = Generate.generateNumber(r);

            if (TypeEnum.ORFANELLI.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                orfanelliInt++;
            } else if (TypeEnum.VICINI_DELLO_ZERO.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                viciniDelloZeroInt++;
            } else if (TypeEnum.SERIE_5_8.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                serie58Int++;
            } 

            if (i == numberOfIteration / 4) {
                gapMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), (((((double) viciniDelloZeroInt / i) * 100) - (expectedMap.get(TypeEnum.VICINI_DELLO_ZERO.getType()))) / (expectedMap.get(TypeEnum.VICINI_DELLO_ZERO.getType()))) * 100);
                gapMap.put(TypeEnum.SERIE_5_8.getType(), (((((double) serie58Int / i) * 100) - (expectedMap.get(TypeEnum.SERIE_5_8.getType()))) / (expectedMap.get(TypeEnum.SERIE_5_8.getType()))) * 100);
                gapMap.put(TypeEnum.ORFANELLI.getType(), (((((double) orfanelliInt / i) * 100) - (expectedMap.get(TypeEnum.ORFANELLI.getType()))) / (expectedMap.get(TypeEnum.ORFANELLI.getType()))) * 100);

                for (Map.Entry<String, Double> entry : gapMap.entrySet()) {
                    if (entry.getValue() < -10.0) {
                        for (TypeEnum type : TypeEnum.values()) {
                            if (type.getType().equalsIgnoreCase(entry.getKey())) {
                                operatingMap.put(type.getType(), true);
                                break;
                            }
                        }
                    }
                }




//            LOG.info("iteration {} - {} {} - {} {} - {} {} - {} {}",
//                    i,
//                    TypeEnum.VICINI_DELLO_ZERO.getType(),
//                    gapGiocoZero,
//                    TypeEnum.SERIE_5_8.getType(),
//                    gapSerie58,
//                    TypeEnum.VICINI_DELLO_ZERO.getType(),
//                    gapViciniDelloZero,
//                    TypeEnum.ORFANELLI.getType(),
//                    gapOrfanelli
//            );
                }
            }
        }


    


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

}
