package org.example.analisi;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StartProcessTest {

    private static final Logger LOG = LoggerFactory.getLogger(StartProcessTest.class);


    @InjectMocks
    private StartProcess startProcess;


    @Test
    public void startBetTest(){

        LinkedHashMap<Integer, Description> mapOfNumbers = new LinkedHashMap<Integer, Description>();
        StartProcess.populateMap(mapOfNumbers);


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

        //Double profit = StartProcess.startBet(50,SerieBetMaps,mapOfNumbers,30);
        //LOG.info("final profit : {} " ,  profit);
    }
}
