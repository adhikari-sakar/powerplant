package com.proshore.powerplant.application.repository;

import com.proshore.powerplant.application.dto.Range;
import com.proshore.powerplant.domain.contracts.BaseRepository;
import com.proshore.powerplant.domain.model.Battery;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class TestBatteryRepository implements BaseRepository<Battery> {

    List<Battery> batteries = new ArrayList<>();

    @Override
    public List<Battery> findByRange(Range range) {
        return this.batteries.stream().filter(battery -> isWithinRange(battery, range)).collect(toList());
    }

    private static Boolean isWithinRange(Battery battery, Range range) {
        return Integer.parseInt(battery.getPostcode().getCode()) >= Integer.parseInt(range.getFrom()) &&
                Integer.parseInt(battery.getPostcode().getCode()) <= Integer.parseInt(range.getTo());
    }

    @Override
    public void saveAll(List<Battery> batteries) {
        this.batteries.addAll(batteries);
    }

    public long count() {
        return this.batteries.size();
    }
}
