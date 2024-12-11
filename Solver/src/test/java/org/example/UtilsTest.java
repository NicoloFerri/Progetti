package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class UtilsTest {

    @InjectMocks
    private Utils utils;

    @BeforeEach
    public void setUp() {
        // Initializes the @InjectMocks and other Mockito annotations
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void calculateNodesTest(){
        utils.calculateNodes(
                100,
                20,
                new String[]{"20"},
                new String[]{"40"},
                new String[]{"20","50","100"},
                new String[]{"40"},
                new String[]{"20"},
                new String[]{"40"},
                new String[]{"20"},
                new String[]{"40"},
                new String[]{"20"},
                new String[]{"40"},
                new String[]{"20"},
                new String[]{"40"},
                90
        );
    }
}
