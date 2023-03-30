package com.proshore.powerplant.domain.contracts;

import com.proshore.powerplant.application.dto.Range;

import java.util.List;

public interface BaseRepository<T> {

    List<T> findByRange(Range r);

    void saveAll(List<T> batteries);
}
