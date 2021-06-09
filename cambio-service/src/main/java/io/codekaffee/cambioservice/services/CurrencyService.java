package io.codekaffee.cambioservice.services;

import io.codekaffee.cambioservice.dto.CambioDTO;
import io.codekaffee.cambioservice.exceptions.CambioNotFoundException;
import io.codekaffee.cambioservice.models.Cambio;
import io.codekaffee.cambioservice.repositories.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyService {

    @Autowired
    private CambioRepository cambioRepository;

    public CambioDTO getValueByCambio(String from, String to, BigDecimal amount){
        Cambio cambio = cambioRepository.findByFromAndTo(from,to)
                .orElseThrow(CambioNotFoundException::new);

        BigDecimal convertedValue = cambio.getConversionFactor().multiply(amount);

        return  new CambioDTO(from, to, convertedValue);
    }
}
