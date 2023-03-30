package com.proshore.powerplant.application.repository;

import com.proshore.powerplant.application.entity.BatteryEntity;
import com.proshore.powerplant.application.mapper.BatteryMapper;
import com.proshore.powerplant.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class BatteryRepositoryTest {
    @Mock
    private BatteryJpaRepository jpaRepository;
    @Mock
    private BatteryMapper mapper;
    @InjectMocks
    private BatteryRepository repository;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void findByRange() {
        when(jpaRepository.findAllByPostcodeBetween("100", "200")).thenReturn(List.of(new BatteryEntity()));
        List<Battery> batteries = repository.findByRange(new Range("100", "200"));
        assertFalse(batteries.isEmpty());
        assertEquals(1, batteries.size());
        verify(jpaRepository).findAllByPostcodeBetween("100", "200");
        verify(mapper).toModel(any(BatteryEntity.class));
    }

    @Test
    void saveAll() {
        repository.saveAll(List.of(battery()));
        verify(jpaRepository).saveAll(anyList());
        verify(mapper).toEntities(anyList());
    }

    private static Battery battery() {
        return new Battery(new Name("ABC"), new Code("100"), new Capacity(100.0));
    }

}