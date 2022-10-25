package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CurrencyRateDto
 */

@JsonTypeName("CurrencyRate")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CurrencyRateDto {

  @JsonProperty("date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @JsonProperty("rates")
  @Valid
  private Map<String, Double> rates = null;

  public CurrencyRateDto date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  */
  @Valid 
  @Schema(name = "date", required = false)
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public CurrencyRateDto rates(Map<String, Double> rates) {
    this.rates = rates;
    return this;
  }

  public CurrencyRateDto putRatesItem(String key, Double ratesItem) {
    if (this.rates == null) {
      this.rates = new HashMap<>();
    }
    this.rates.put(key, ratesItem);
    return this;
  }

  /**
   * Get rates
   * @return rates
  */
  
  @Schema(name = "rates", required = false)
  public Map<String, Double> getRates() {
    return rates;
  }

  public void setRates(Map<String, Double> rates) {
    this.rates = rates;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyRateDto currencyRate = (CurrencyRateDto) o;
    return Objects.equals(this.date, currencyRate.date) &&
        Objects.equals(this.rates, currencyRate.rates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, rates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyRateDto {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

