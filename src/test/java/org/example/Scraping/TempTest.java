package org.example.Scraping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TempTest {
    public Temp temp;
    @BeforeEach
    public void setUp(){
        temp = new Temp();
    }
    @Test
    void tempList() {
        List<String> tempList = temp.tempList();
        assertNotNull(tempList);
        assertFalse(tempList.isEmpty());
    }
}