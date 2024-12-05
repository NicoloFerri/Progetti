package org.example.analisi;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculateDeviation {

    public static void calc(){
        double stdDeviation = 0.027027027027027;
        int initialRound = 100;
        Integer[] sequence = Utils.returnSequence(initialRound);
        LinkedHashMap<Integer, StudyObj> countingMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, Description> map = new LinkedHashMap<>();
        Utils.populateMap(map);

        for(Map.Entry<Integer,Description> entry : map.entrySet() ){
            StudyObj obj = new StudyObj();
            obj.setCount(0);
            countingMap.put(entry.getKey(), obj);
        }

        for( int i=0 ; i<sequence.length-1 ; i++){
            for(Map.Entry<Integer,StudyObj> entry : countingMap.entrySet()){
                StudyObj obj = entry.getValue();
                if(entry.getKey().equals(sequence[i])){
                    obj.setCount(entry.getValue().getCount()+1);
                }
                obj.setPercentage((double)obj.getCount()/(i+1));
                obj.setDeviation((obj.getPercentage()-stdDeviation) /stdDeviation);
                //countingMap.put(entry.getKey(), obj);
                }
            }

        }





    }

