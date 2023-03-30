package com.proshore.powerplant.application.service;

import com.proshore.powerplant.application.dto.Range;
import com.proshore.powerplant.application.mapper.BatteryMapperImpl;
import com.proshore.powerplant.application.repository.BatteryRepository;
import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.Capacity;
import com.proshore.powerplant.domain.model.Code;
import com.proshore.powerplant.domain.model.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class BatteryServiceTest {
    @Mock
    private BatteryRepository repository;
    private BatteryService service;

    @BeforeEach
    void setUp() {
        openMocks(this);
        service = new BatteryService(repository, new BatteryMapperImpl());
    }

    @Test
    void registerBatteries() {
        service.registerBatteries(List.of());
        verify(repository).saveAll(anyList());
    }

    @Test
    void batteryStatistics() {
        Range range = new Range("5000", "10000");
        when(repository.findByRange(range)).thenReturn(List.of(
                battery("Midland", "6057", 50500.0),
                battery("Cannington", "6107", 13500.0)));

        var response = service.batteryStatistics(range);

        assertNotNull(response);
        assertFalse(response.getNames().isEmpty());
        assertEquals(2, response.getNames().size());
        assertEquals("Cannington", response.getNames().get(0));
        assertEquals("Midland", response.getNames().get(1));
        assertEquals(64000.0, response.getTotalCapacity());
        assertEquals(32000.0, response.getAverageCapacity());
        verify(repository).findByRange(range);
    }

    private static Battery battery(String name, String code, Double capacity) {
        return new Battery(new Name(name), new Code(code), new Capacity(capacity));
    }
}