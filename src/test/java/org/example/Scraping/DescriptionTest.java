package org.example.Scraping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DescriptionTest {

    private Description description;

    @BeforeEach
    public void setUp() {
        description = new Description();
    }

    @Test
    void descList() {
        List<String> descriptions = description.descList();
        assertNotNull(descriptions);
        assertFalse(descriptions.isEmpty());
    }
}
