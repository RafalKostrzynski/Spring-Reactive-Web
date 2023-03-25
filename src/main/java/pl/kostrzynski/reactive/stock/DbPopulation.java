package pl.kostrzynski.reactive.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbPopulation {

    private final StockJpaRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void populate() {

        final var stock1 = StockJpaEntity.builder()
                .name("test")
                .stockValue(new BigDecimal("100.00"))
                .newStock(true)
                .build();
        final var stock2 = StockJpaEntity.builder()
                .name("test")
                .stockValue(new BigDecimal("200.00"))
                .newStock(true)
                .build();
        final var stock3 = StockJpaEntity.builder()
                .name("test")
                .stockValue(new BigDecimal("300.00"))
                .newStock(true)
                .build();
        final var stock4 = StockJpaEntity.builder()
                .name("test")
                .stockValue(new BigDecimal("400.00"))
                .newStock(true)
                .build();

        this.repository.saveAll(List.of(stock1, stock2, stock3, stock4)).subscribe();
    }
}
