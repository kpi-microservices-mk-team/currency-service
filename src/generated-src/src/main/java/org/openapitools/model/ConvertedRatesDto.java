package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ConvertedRatesDto
 */

@JsonTypeName("ConvertedRates")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ConvertedRatesDto {

  @JsonProperty("target")
  private String target;

  @JsonProperty("value")
  private Double value;

  public ConvertedRatesDto target(String target) {
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
  */
  @NotNull 
  @Schema(name = "target", required = true)
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public ConvertedRatesDto value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  */
  
  @Schema(name = "value", required = false)
  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertedRatesDto convertedRates = (ConvertedRatesDto) o;
    return Objects.equals(this.target, convertedRates.target) &&
        Objects.equals(this.value, convertedRates.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(target, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertedRatesDto {\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

