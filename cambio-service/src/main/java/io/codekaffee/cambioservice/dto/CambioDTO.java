package io.codekaffee.cambioservice.dto;

import java.math.BigDecimal;

public class CambioDTO {
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal convertedValue;

    private String env;

    public CambioDTO() {
    }

    public CambioDTO(String fromCurrency, String toCurrency, BigDecimal convertedValue) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.convertedValue = convertedValue;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
