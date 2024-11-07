package Utils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.File;

public class ReadCsvTest {

    @InjectMocks
    private ReadCsv readCsv;

    @Test
    public void readTest(){
        readCsv.read(new File(""));
    }
}
