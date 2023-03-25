package pl.kostrzynski.reactive.stock;

import jakarta.validation.constraints.NotNull;

record StockViewModel(Long id,
                      @NotNull String name,
                      @NotNull String stockValue) {
}
