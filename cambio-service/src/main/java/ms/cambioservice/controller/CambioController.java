package ms.cambioservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.cambioservice.model.Cambio;
import ms.cambioservice.repository.CambioRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Cambio endpoint")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    private final CambioRepository repository;
    private final Environment environment;

    /**
     *  http://localhost:8000/cambio-service/10/USD/BRL
     */

    @Operation(summary = "Get Cambio from currency")
    @ApiResponse(responseCode = "200", description = "Successfully cambio")
    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable BigDecimal amount, @PathVariable String from, @PathVariable String to) {

        log.info("getCambio was called with => {}, {} and {}", amount, from, to);

        var cambio = repository.findByFromAndTo(from, to);
        if (cambio == null) throw new RuntimeException("Currency Unsupported");

        var port = environment.getProperty("local.server.port");
        cambio.setEnvironment(port);

        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount).setScale(2, RoundingMode.CEILING);
        cambio.setConvertedValue(convertedValue);

        return cambio;
    }

}
