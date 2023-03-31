package com.proshore.powerplant.application.service;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.Range;
import com.proshore.powerplant.application.mapper.BatteryMapperImpl;
import com.proshore.powerplant.application.repository.TestBatteryRepository;
import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.Capacity;
import com.proshore.powerplant.domain.model.Code;
import com.proshore.powerplant.domain.model.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BatteryServiceTest {

    private final TestBatteryRepository testRepository = new TestBatteryRepository();
    private final BatteryService service = new BatteryService(testRepository, new BatteryMapperImpl());

    @Test
    void registerBatteries() {
        service.registerBatteries(List.of(new BatteryRequest("Cannington", "6107", 13500)));
        assertThat(testRepository.count()).isEqualTo(1);
    }

    @Test
    void batteryStatistics() {
        testRepository.saveAll(List.of(
                new Battery(new Name("Midland"), new Code("6057"), new Capacity(50500.0)),
                new Battery(new Name("Cannington"), new Code("6107"), new Capacity(13500.0)))
        );
        Range range = new Range("5000", "10000");
        var response = service.batteryStatistics(range);

        assertNotNull(response);
        assertFalse(response.getNames().isEmpty());
        assertEquals(2, response.getNames().size());
        assertEquals("Cannington", response.getNames().get(0));
        assertEquals("Midland", response.getNames().get(1));
        assertEquals(64000.0, response.getTotalCapacity());
        assertEquals(32000.0, response.getAverageCapacity());
        assertEquals(2, testRepository.count());
    }
}