package Utils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class ReadCsvTest {

    @InjectMocks
    private ReadCsv readCsv;

    @Test
    public void readTest(){
        readCsv.read();
    }
}
