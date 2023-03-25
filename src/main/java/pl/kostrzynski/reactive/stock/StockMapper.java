package pl.kostrzynski.reactive.stock;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.math.BigDecimal;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {BigDecimal.class, Objects.class})
interface StockMapper {

    Stock toDomain(StockJpaEntity stockJpaEntity);

    @Mapping(target = "newStock", ignore = true)
    StockJpaEntity toJpaEntity(Stock stock);

    StockViewModel toViewModel(Stock stock);

    Stock toDomain(StockViewModel stockViewModel);
}
