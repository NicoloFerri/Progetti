package org.example.analisi;

import com.opencsv.CSVWriter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StartProcess {

    private static final Logger LOG = LoggerFactory.getLogger(StartProcess.class);

    public static void runBetting(){
        int totalNumbers = 37;
        int iterationForTest = 100;
        double sogliaToStartBet = -30.0;
        int duration = 1000000000;

        LOG.info("initialize Sequence...");
        Integer[] sequence = Utils.returnSequence(duration);


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

        //LOG.info("starting process.. ");
        //LinkedList<String> rouletteNumbersList = new LinkedList<>(Arrays.asList("0", "32", "15", "19", "4", "21", "2", "25", "17", "34", "6", "27", "13", "36", "11", "30", "8", "23", "10", "5", "24", "16", "33", "1", "20", "14", "31", "9", "22", "18", "29", "7", "28", "12", "35", "3", "26"));

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
        SerieBetMaps.put(33,0.5);
        SerieBetMaps.put(36,0.5);


        LinkedHashMap<Integer, Description> mapOfNumbers = new LinkedHashMap<Integer, Description>();
        Utils.populateMap(mapOfNumbers);
        Integer viciniDelloZeroInt = 0;
        Integer serie58Int = 0;
        Integer orfanelliInt = 0;

        int n;
        int x=0;
        int iter=0;
        boolean betMade = false;
        Report report = new Report(0.0,0);


        String filePath = "C:\\Users\\nicolo\\Desktop\\Progetti\\Roulette\\src\\main\\java\\org\\example\\report\\report.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {;
            writer.writeNext(new String[]{"Data","Da Estrazione", "A Estrazione","GAP", "BetType", "Profit"});

        for (int i = 0; i < sequence.length-1; i++) {
            n = sequence[i];

            if (betMade){
                orfanelliInt=0;
                viciniDelloZeroInt=0;
                serie58Int=0;
                iter=0;
                betMade = false;
            }

            if (TypeEnum.ORFANELLI.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                orfanelliInt++;
            } else if (TypeEnum.VICINI_DELLO_ZERO.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                viciniDelloZeroInt++;
            } else if (TypeEnum.SERIE_5_8.getType().equalsIgnoreCase(mapOfNumbers.get(n).getType())) {
                serie58Int++;
            }

            iter++;
            if (iter == iterationForTest){
                report.setIterazione(i);
                gapMap.put(TypeEnum.VICINI_DELLO_ZERO.getType(), (((((double) viciniDelloZeroInt / iter) * 100) - (expectedMap.get(TypeEnum.VICINI_DELLO_ZERO.getType()))) / (expectedMap.get(TypeEnum.VICINI_DELLO_ZERO.getType()))) * 100);
                gapMap.put(TypeEnum.SERIE_5_8.getType(), (((((double) serie58Int / iter) * 100) - (expectedMap.get(TypeEnum.SERIE_5_8.getType()))) / (expectedMap.get(TypeEnum.SERIE_5_8.getType()))) * 100);
                gapMap.put(TypeEnum.ORFANELLI.getType(), (((((double) orfanelliInt / iter) * 100) - (expectedMap.get(TypeEnum.ORFANELLI.getType()))) / (expectedMap.get(TypeEnum.ORFANELLI.getType()))) * 100);
                String betOn = "";
                for (Map.Entry<String, Double> entry : gapMap.entrySet()) {
                    if (entry.getValue() < sogliaToStartBet) {
                        if(entry.getKey().equalsIgnoreCase(TypeEnum.VICINI_DELLO_ZERO.getType())){
                            LOG.info("[STARTING BET] - bet on {} ", TypeEnum.VICINI_DELLO_ZERO.getType());
                             Utils.startBet(iterationForTest,viciniDelloZeroBetMaps,mapOfNumbers,report,sequence);
                            betOn=TypeEnum.VICINI_DELLO_ZERO.getType();
                        }else if(entry.getKey().equalsIgnoreCase(TypeEnum.SERIE_5_8.getType())) {
                            LOG.info("[STARTING BET] - bet on {} ", TypeEnum.SERIE_5_8.getType());
                            //Utils.startBet(iterationForTest,SerieBetMaps,mapOfNumbers,report,sequence);
                            betOn=TypeEnum.SERIE_5_8.getType();
                        }else if(entry.getKey().equalsIgnoreCase(TypeEnum.ORFANELLI.getType())) {
                            LOG.info("[STARTING BET] - bet on {} ", TypeEnum.ORFANELLI.getType());
                            //Utils.startBet(iterationForTest,orfanelliBetMaps,mapOfNumbers,report,sequence);
                            betOn=TypeEnum.ORFANELLI.getType();
                        }
                        break;
                    }
                }
                if(i!=report.getIterazione()) {
                    int inizio = i;
                    int fine = report.getIterazione();
                    writer.writeNext(new String[]{ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss")), String.valueOf(inizio),String.valueOf(fine),String.valueOf(fine-inizio),betOn, String.valueOf(report.getProfitto())});
                    i=report.getIterazione();
                }
                betMade=true;

            }
        }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }








}
