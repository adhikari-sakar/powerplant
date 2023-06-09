package com.proshore.powerplant.application.mapper;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.BatteryResponse;
import com.proshore.powerplant.application.entity.BatteryEntity;
import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring")
public interface BatteryMapper {
    @Mapping(target = "name.name", source = "name")
    @Mapping(target = "postcode.code", source = "postcode")
    @Mapping(target = "capacity.unit", source = "capacity")
    Battery toModel(BatteryEntity entity);

    @Mapping(source = "name.name", target = "name")
    @Mapping(source = "postcode.code", target = "postcode")
    @Mapping(source = "capacity.unit", target = "capacity")
    BatteryEntity toEntity(Battery model);

    List<BatteryEntity> toEntities(List<Battery> batteries);

    @Mapping(target = "name.name", source = "name")
    @Mapping(target = "postcode.code", source = "postcode")
    @Mapping(target = "capacity.unit", source = "capacity")
    Battery toModel(BatteryRequest request);

    List<Battery> toModels(List<BatteryRequest> requests);

    @Mapping(source = "names", target = "names")
    @Mapping(source = "totalCapacity.unit", target = "totalCapacity")
    @Mapping(source = "averageCapacity.unit", target = "averageCapacity")
    BatteryResponse toResponse(Battery.Statistics stat);

    default List<String> toNames(List<Name> names) {
        return names.stream().map(Name::getName).collect(toList());
    }
}
