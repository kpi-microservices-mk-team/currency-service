package com.example.currencyservice.infrastructure.bean;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "rateId")
public class PersistenceCurrencyRate {

    @EmbeddedId
    private RateId rateId;
    private double rate;

    @Embeddable
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RateId implements Serializable {
        @Serial
        private static final long serialVersionUID = -2768409849487631735L;
        private LocalDate effectiveDate;
        private String currency;
    }
}
