package com.example.trafiklabs;

import com.example.trafiklabs.service.LineInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TrafikLabsApplicationTest {
    @SpyBean
    CommandLineExecuter commandLineExecuter;

    @MockBean
    LineInformationService lineInformationService;

    @Test
    void contextLoads() {
        when(lineInformationService.fetchBusLinesWithTheMostStops(10)).thenReturn(new ArrayList<>());
        verify(commandLineExecuter, times(1)).run();
    }

}