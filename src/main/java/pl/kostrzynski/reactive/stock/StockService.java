package pl.kostrzynski.reactive.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class StockService {

    private final StockJpaRepository stockJpaRepository;

    private final StockMapper stockMapper;

    Flux<Stock> getAllStocks() {

        return this.stockJpaRepository.findAll()
                .map(this.stockMapper::toDomain);
    }

    Mono<Long> save(final Stock stock) {

        final var entity = stockMapper.toJpaEntity(stock);
        return this.stockJpaRepository.save(entity)
                .mapNotNull(StockJpaEntity::getId);
    }

}
