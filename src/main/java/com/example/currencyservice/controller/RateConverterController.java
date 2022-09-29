package com.example.currencyservice.controller;

import com.example.currencyservice.usecases.ConvertRateUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.ConvertRatesApi;
import org.openapitools.model.ConvertedRatesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RateConverterController implements ConvertRatesApi {

    private final ConvertRateUseCase convertRateUseCase;

    @Override
    public ResponseEntity<ConvertedRatesDto> convertRates(String target, String from, Double value) {
        final var converted = convertRateUseCase.convertRate(target, from, value);

        return ResponseEntity.ok(
                new ConvertedRatesDto()
                        .target(converted.getCurrency())
                        .value(converted.getValue())
        );
    }
}
