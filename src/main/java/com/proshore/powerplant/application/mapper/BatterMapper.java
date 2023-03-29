package com.proshore.powerplant.application.mapper;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.BatteryResponse;
import com.proshore.powerplant.application.entity.BatteryEntity;
import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.BatteryStatistics;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BatterMapper {
    @Mapping(target = "name.name", source = "name")
    @Mapping(target = "postCode.code", source = "postCode")
    @Mapping(target = "capacity.unit", source = "capacity")
    Battery toModel(BatteryEntity entity);

    @Mapping(source = "name.name", target = "name")
    @Mapping(source = "postCode.code", target = "postCode")
    @Mapping(source = "capacity.unit", target = "capacity")
    BatteryEntity toEntity(Battery model);

    List<BatteryEntity> toEntities(List<Battery> batteries);

    @Mapping(target = "name.name", source = "name")
    @Mapping(target = "postCode.code", source = "postCode")
    @Mapping(target = "capacity.unit", source = "capacity")
    Battery toModel(BatteryRequest request);

    List<Battery> toModels(List<BatteryRequest> requests);

    @Mapping(source = "totalCapacity.unit", target = "totalCapacity")
    @Mapping(source = "averageCapacity.unit", target = "averageCapacity")
    BatteryResponse toResponse(BatteryStatistics stat);
}
