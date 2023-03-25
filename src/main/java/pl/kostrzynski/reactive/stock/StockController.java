package pl.kostrzynski.reactive.stock;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "v1/api/stock")
@RequiredArgsConstructor
class StockController {

    private final StockService stockService;

    private final StockMapper mapper;

    @GetMapping
    ResponseEntity<Flux<StockViewModel>> getStocks() {

        final Flux<StockViewModel> stockList = this.stockService.getAllStocks()
                .map(this.mapper::toViewModel);
        return ResponseEntity.ok(stockList);
    }

    @PostMapping
    ResponseEntity<Mono<Long>> saveStock(@RequestBody @Valid StockViewModel stockViewModel) {

        final var stock = this.mapper.toDomain(stockViewModel);
        final var stockId = this.stockService.save(stock);

        return ResponseEntity.ok(stockId);
    }

}
