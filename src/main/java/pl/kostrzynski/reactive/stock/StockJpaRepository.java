package pl.kostrzynski.reactive.stock;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StockJpaRepository extends R2dbcRepository<StockJpaEntity, Long> {

}
