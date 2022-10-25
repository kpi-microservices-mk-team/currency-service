package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UpdateRateDto
 */

@JsonTypeName("UpdateRate")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class UpdateRateDto {

  @JsonProperty("rateDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate rateDate;

  @JsonProperty("currency")
  private String currency;

  public UpdateRateDto rateDate(LocalDate rateDate) {
    this.rateDate = rateDate;
    return this;
  }

  /**
   * Get rateDate
   * @return rateDate
  */
  @Valid @Pattern(regexp = "/([0-9]{4})-(?:[0-9]{2})-([0-9]{2})/") 
  @Schema(name = "rateDate", example = "Fri May 17 03:00:00 MSK 2019", required = false)
  public LocalDate getRateDate() {
    return rateDate;
  }

  public void setRateDate(LocalDate rateDate) {
    this.rateDate = rateDate;
  }

  public UpdateRateDto currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  */
  
  @Schema(name = "currency", required = false)
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateRateDto updateRate = (UpdateRateDto) o;
    return Objects.equals(this.rateDate, updateRate.rateDate) &&
        Objects.equals(this.currency, updateRate.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rateDate, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateRateDto {\n");
    sb.append("    rateDate: ").append(toIndentedString(rateDate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

