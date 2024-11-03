package Utils;

import Models.ThreeBpFlopIpUnprocessed;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsv {


    public static List<ThreeBpFlopIpUnprocessed> read(){
        List<ThreeBpFlopIpUnprocessed> records = new ArrayList<>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\Super uniqueorn\\Desktop\\Progetti\\AggregationAnalysis\\src\\main\\resources\\report_IP_Full.csv"));
            List<String[]> csvRecords  = csvReader.readAll();

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
                        obj.setBet1101Freq(new BigDecimal(record[7]));
                        obj.setBet1101Ev(new BigDecimal(record[8]));
                        obj.setBet875Freq(new BigDecimal(record[9]));
                        obj.setBet875Ev(new BigDecimal(record[10]));
                        obj.setBet438Freq(new BigDecimal(record[11]));
                        obj.setBet438Ev(new BigDecimal(record[12]));
                        obj.setCheckFreq(new BigDecimal(record[13]));
                        obj.setCheckEv(new BigDecimal(record[14]));
                        return obj;
                    })
                    .collect(Collectors.toList());

        }catch(IOException | CsvException e ){
            System.out.println("Exception");
        }
        return records;
    }

}
