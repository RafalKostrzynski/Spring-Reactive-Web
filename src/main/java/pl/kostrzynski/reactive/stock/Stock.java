package pl.kostrzynski.reactive.stock;

import java.math.BigDecimal;

record Stock(Long id, String name, BigDecimal stockValue) {
}
