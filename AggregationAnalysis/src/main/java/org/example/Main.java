package org.example;

import Service.AnalisiService;
import Utils.ReadCsv;

public class Main {
    public static void main(String[] args) {
       AnalisiService.saveService(ReadCsv.read());
    }
}