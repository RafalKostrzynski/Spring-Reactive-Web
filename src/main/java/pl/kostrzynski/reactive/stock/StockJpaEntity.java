package pl.kostrzynski.reactive.stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("STOCK_JPA_ENTITY")
class StockJpaEntity implements Persistable<Long> {

    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("stock_value")
    private BigDecimal stockValue;
    @Transient
    private boolean newStock;

    @Override
    @Transient
    public boolean isNew() {
        return this.newStock || id == null;
    }
}
