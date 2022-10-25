/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ConvertedRatesDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "ConvertRates", description = "the ConvertRates API")
public interface ConvertRatesApi {

    /**
     * GET /api/v1/rates/convert : Convert rates
     *
     * @param target Target currency (optional)
     * @param from From currency (optional)
     * @param value  (optional)
     * @return Get rates successful (status code 200)
     */
    @Operation(
        operationId = "convertRates",
        summary = "Convert rates",
        tags = { "convert-rates" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Get rates successful", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ConvertedRatesDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/rates/convert",
        produces = { "application/json" }
    )
    ResponseEntity<ConvertedRatesDto> convertRates(
        @Parameter(name = "target", description = "Target currency") @Valid @RequestParam(value = "target", required = false) String target,
        @Parameter(name = "from", description = "From currency") @Valid @RequestParam(value = "from", required = false) String from,
        @Parameter(name = "value", description = "") @Valid @RequestParam(value = "value", required = false) Double value
    );

}
