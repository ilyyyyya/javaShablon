package com.example.task1516;

import com.example.task1516.entity.Departure;
import com.example.task1516.repository.DepartureRepository;
import com.example.task1516.service.DepartureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;


import java.util.List;
@ExtendWith(MockitoExtension.class)
public class DepartureServiceImplTest {
    @Mock
    private DepartureRepository departureRepository;
    @Captor
    ArgumentCaptor<Departure> captor;

    @Test
    public void getDepartures(){
        Departure departure = new Departure();
        departure.setType("plane");
        Departure departure2 = new Departure();
        departure2.setType("bus");

        Mockito.when(departureRepository.findAll()).thenReturn(List.of(departure, departure2));

        DepartureService departureService = new DepartureService(departureRepository);
        Assertions.assertEquals(2, departureService.getDepartures().size());
        Assertions.assertEquals("plane", departureService.getDepartures().get(0).getType());
    }
    @Test
    public void addNewDeparture(){
        Departure departure = new Departure();
        departure.setType("type_19");
        DepartureService departureService = new DepartureService(departureRepository);
        departureService.addDeparture(departure);
        Mockito.verify(departureRepository).save(captor.capture());
        Departure captured = captor.getValue();
        Assertions.assertEquals("type_19", captured.getType());
    }
}


