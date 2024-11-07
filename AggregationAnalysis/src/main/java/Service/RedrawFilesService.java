package Service;

import com.opencsv.CSVReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RedrawFilesService {
    public static File[] redrawFilesFromFolder(String repo){
        return new File(repo).listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));
    }
}
