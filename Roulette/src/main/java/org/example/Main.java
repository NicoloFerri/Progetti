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
        expectedMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), ((10.0 / totalNumbers) * 100)); //27.02
        expectedMap.put(TypeEnum.GIOCO_ZERO.getType(), ((7.0 / totalNumbers) * 100)); //18.91

        HashMap<String, Boolean> operatingMap = new HashMap<String, Boolean>();
        operatingMap.put(TypeEnum.ORFANELLI.getType(), false);
        operatingMap.put(TypeEnum.SERIE_5_8.getType(), false);
        operatingMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), false);
        operatingMap.put(TypeEnum.GIOCO_ZERO.getType(), false);

        HashMap<String, Double> gapMap = new HashMap<String, Double>();
        gapMap.put(TypeEnum.ORFANELLI.getType(), 0d);
        gapMap.put(TypeEnum.SERIE_5_8.getType(), 0d);
        gapMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), 0d);
        gapMap.put(TypeEnum.GIOCO_ZERO.getType(), 0d);

        LOG.info("starting process.. ");
        LinkedList<String> rouletteNumbersList = new LinkedList<>(Arrays.asList("0", "32", "15", "19", "4", "21", "2", "25", "17", "34", "6", "27", "13", "36", "11", "30", "8", "23", "10", "5", "24", "16", "33", "1", "20", "14", "31", "9", "22", "18", "29", "7", "28", "12", "35", "3", "26"));
        HashMap<Integer,Double> orfanelliBetMaps = new HashMap<Integer,Double>();
        orfanelliBetMaps.put(1,1.0);
        orfanelliBetMaps.put(6,0.5);
        orfanelliBetMaps.put(9,0.5);
        orfanelliBetMaps.put(14,0.5);
        orfanelliBetMaps.put(17,0.5);
        orfanelliBetMaps.put(201,0.5);
        orfanelliBetMaps.put(31,0.5);
        orfanelliBetMaps.put(34,0.5);

        


        LinkedHashMap<Integer, Description> mapOfNumbers = new LinkedHashMap<Integer, Description>();
        populateMap(mapOfNumbers);
        Integer giocoZeroInt = 0;
        Double giocoZeroMed = 0D;
        Integer viciniDelloZeroInt = 0;
        Double viciniDelloZeroMed = 0D;
        Integer serie58Int = 0;
        Double serie58Med = 0D;
        Integer orfanelliInt = 0;
        Double orfanelliMed = 0D;

        double gapGiocoZero = 0d;
        double gapSerie58 = 0d;
        double gapViciniDelloZero = 0d;
        double gapOrfanelli = 0d;
        int n;
        for (int i = 1; i < numberOfIteration; i++) {
            n = Generate.generateNumber(r);
//           LOG.info("[NUMERO] {} - [COLOR] {} - [RIGA] {} - [COLONNA] {} - {} ",
//                   n ,
//                   mapOfNumbers.get(n).getColor(),
//                   mapOfNumbers.get(n).getRiga(),
//                   mapOfNumbers.get(n).getColonna(),
//                   mapOfNumbers.get(n).getType()
//           );
            if (TypeEnum.ORFANELLI.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                orfanelliInt++;

                ;
            } else if (TypeEnum.VICINI_DELLO_ZERO.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                viciniDelloZeroInt++;

            } else if (TypeEnum.SERIE_5_8.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                serie58Int++;

            } else {
                giocoZeroInt++;
            }

            if (i == numberOfIteration / 4) {
                gapMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), (((((double) viciniDelloZeroInt / i) * 100) - (expectedMap.get(TypeEnum.VICINI_DELLO_ZERO.getType()))) / (expectedMap.get(TypeEnum.VICINI_DELLO_ZERO.getType()))) * 100);
                gapMap.put(TypeEnum.GIOCO_ZERO.getType(), (((((double) giocoZeroInt / i) * 100) - (expectedMap.get(TypeEnum.GIOCO_ZERO.getType()))) / (expectedMap.get(TypeEnum.GIOCO_ZERO.getType()))) * 100);
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


                for (Map.Entry<String, Boolean> entry : operatingMap.entrySet()) {
                    if (Boolean.TRUE.equals(entry.getValue())) {
                        for (TypeEnum typeEnum : TypeEnum.values()) {
                            if (typeEnum.getType().equalsIgnoreCase(entry.getKey())) {
                                setTypeOfBet(typeEnum.getType());
                            }
                        }
                    }


//            LOG.info("iteration {} - {} {} - {} {} - {} {} - {} {}",
//                    i,
//                    TypeEnum.GIOCO_ZERO.getType(),
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
    }


        public static void setTypeOfBet(String type){
         List<Puntata> listOfNumberToBet = new ArrayList<>();

        }


    public static void populateMap(LinkedHashMap<Integer, Description> mapOfNumbers) {
        mapOfNumbers.put(0, new Description("Green", null, null, TypeEnum.GIOCO_ZERO.getType()));
        mapOfNumbers.put(32, new Description("Red", 2, 3, TypeEnum.GIOCO_ZERO.getType()));
        mapOfNumbers.put(15, new Description("Black", 1, 1, TypeEnum.GIOCO_ZERO.getType()));
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
        mapOfNumbers.put(12, new Description("Red", 2, 1, TypeEnum.GIOCO_ZERO.getType()));
        mapOfNumbers.put(35, new Description("Black", 3, 3, TypeEnum.GIOCO_ZERO.getType()));
        mapOfNumbers.put(3, new Description("Red", 1, 3, TypeEnum.GIOCO_ZERO.getType()));
        mapOfNumbers.put(26, new Description("Black", 3, 2, TypeEnum.GIOCO_ZERO.getType()));
    }

}