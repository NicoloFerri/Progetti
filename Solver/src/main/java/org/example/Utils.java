package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Utils {
    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);


    private final String PIPE = "|";
    private final String MINUS = "-";
    private final String CHECK = "x";
    private final String BET = "b";
    private final String FLOP = "F";
    private final String TURN = "T";
    private final String RIVER = "R";

    public void calculateNodes (
                                   int initialEffStack ,
                                   int initialPotSize,
                                   String[] flopBetSizeIP,
                                   String[] flopRaiseSizeIP,
                                   String[] flopBetSizeOOP,
                                   String[] flopRaiseSizeOOP,
                                   String[] turnBetSizeIP,
                                   String[] turnRaiseSizeIP,
                                   String[] turnBetSizeOOP,
                                   String[] turnRaiseSizeOOP,
                                   String[] riverBetSizeIP,
                                   String[] riverRaiseSizeIP,
                                   String[] riverBetSizeOOP,
                                   String[] riverRaiseSizeOOP,
                                   Integer allinTreeShold
    ){
        int stackIP = initialEffStack;
        int stackOOP = initialEffStack;

        HashMap<String,Node> mapOfNodes = new HashMap<>();
        LinkedList<StringBuilder> listOfNodes = new LinkedList<>();


                for (String size : flopBetSizeOOP) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(FLOP).append(PIPE).append(BET).append(Integer.parseInt(size));
                    LOG.info("{}", sb);
                    mapOfNodes.put(sb.toString(),new Node(sb.toString(),0.0,Choice.BET));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(FLOP).append(PIPE).append(CHECK);
                LOG.info("{}", sb);
                mapOfNodes.put(sb.toString(),new Node(sb.toString(),0.0,Choice.CHECK));

                for(Map.Entry<String,Node> entry : mapOfNodes.entrySet()){

                }



            }






    }




