package Utils;

import Models.ThreeBpFlopIpUnprocessed;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.lang.reflect.Field;


import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReadCsv {


    public static List<ThreeBpFlopIpUnprocessed> read(File file){
        List<ThreeBpFlopIpUnprocessed> records = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            List<String[]> csvRecords  = csvReader.readAll();

            Integer firstColumn = csvRecords.get(0).length;

            HashMap<Integer,BigDecimal> mapOfAAmount = new HashMap<>();
            int k=1;
            Pattern pattern = Pattern.compile("\\b\\d+\\b");

            for(String s : csvRecords.get(0)){
               if(s.contains("BET") && s.contains("freq")){
                   Matcher matcher = pattern.matcher(s);
                   if (matcher.find()) {
                       mapOfAAmount.put(k,new BigDecimal(matcher.group()));
                       k+=3;
                   }
               }

            }

            records = csvRecords .stream()
                    .skip(1) // Salta l'intestazione
                    .map(record -> {
                        ThreeBpFlopIpUnprocessed obj = new ThreeBpFlopIpUnprocessed();
                        obj.setFlop(record[0]);
                        obj.setHand(record[1]);
                        obj.setWeight(new BigDecimal(record[2]));
                        obj.setMatchups(new BigDecimal(record[3]));
                        obj.setIpEquity(new BigDecimal(record[4]));
                        obj.setIpEv(new BigDecimal(record[5]));
                        obj.setIpEqr(new BigDecimal(record[6]));

                        // Array dei nomi dei campi di dimensione e check
                        String[] fieldNames = {
                                "SizeOneFreq", "SizeOneAmount", "SizeOneEv",
                                "SizeTwoFreq", "SizeTwoAmount", "SizeTwoEv",
                                "SizeThreeFreq", "SizeThreeAmount", "SizeThreeEv",
                                "SizeFourFreq", "SizeFourAmount", "SizeFourEv",
                                "SizeFiveFreq", "SizeFiveAmount", "SizeFiveEv",
                                "SizeSixFreq", "SizeSixAmount", "SizeSixEv",
                                "SizeSevenFreq", "SizeSevenAmount", "SizeSevenEv",
                                "SizeEightFreq", "SizeEightAmount", "SizeEightEv",
                                "SizeNineFreq", "SizeNineAmount", "SizeNineEv",
                                "SizeTenFreq", "SizeTenAmount", "SizeTenEv",
                                "checkFreq", "checkEv"
                        };
                        boolean added=false;
                        int i=0;
                        int j=0;
                        for (int w = 0; w < mapOfAAmount.size()*3; w++) {
                            try {
                                Field field = ThreeBpFlopIpUnprocessed.class.getDeclaredField(fieldNames[w]);
                                field.setAccessible(true);
                                    if(mapOfAAmount.containsKey(j)){
                                        field.set(obj,mapOfAAmount.get(j));
                                        j++;
                                    }else{
                                        field.set(obj, new BigDecimal(record[i+7]));
                                        i++;
                                        j++;
                                    }
                            } catch (NoSuchFieldException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }

                        obj.setCheckFreq(new BigDecimal(record[firstColumn-2]));
                        obj.setCheckEv(new BigDecimal(record[firstColumn-1]));
                        return obj;
                    })
                    .collect(Collectors.toList());

        }catch(IOException | CsvException e ){
            System.out.println("Exception");
        }
        return records;
    }

}
