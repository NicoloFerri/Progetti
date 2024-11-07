package org.example;

import Service.AnalisiService;
import Service.RedrawFilesService;
import Utils.ReadCsv;
import Utils.UtilsEnum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(RedrawFilesService.redrawFilesFromFolder(UtilsEnum.REPO.getPath())).forEach(file ->{
            AnalisiService.saveService(ReadCsv.read(file));
                });
    }
}