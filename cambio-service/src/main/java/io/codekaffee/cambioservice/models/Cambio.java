package io.codekaffee.cambioservice.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;

    private String environment;

    public Cambio() { }

    public Cambio(Long id, String from, String to, BigDecimal conversionFactor, BigDecimal convertedValue) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cambio)) return false;

        Cambio cambio = (Cambio) o;

        if (getId() != null ? !getId().equals(cambio.getId()) : cambio.getId() != null) return false;
        if (getFrom() != null ? !getFrom().equals(cambio.getFrom()) : cambio.getFrom() != null) return false;
        if (getTo() != null ? !getTo().equals(cambio.getTo()) : cambio.getTo() != null) return false;
        if (getConversionFactor() != null ? !getConversionFactor().equals(cambio.getConversionFactor()) : cambio.getConversionFactor() != null)
            return false;
        if (getConvertedValue() != null ? !getConvertedValue().equals(cambio.getConvertedValue()) : cambio.getConvertedValue() != null)
            return false;
        return getEnvironment() != null ? getEnvironment().equals(cambio.getEnvironment()) : cambio.getEnvironment() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
