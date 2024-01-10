package com.gtos.gtos.model.dto;

import java.math.BigDecimal;

public class GenelDurumDTO {
    public BigDecimal toplamTahsilat;

    public BigDecimal toplamGiderler;

    public BigDecimal genelDurum;

    public BigDecimal getToplamTahsilat() {
        return toplamTahsilat;
    }

    public void setToplamTahsilat(BigDecimal toplamTahsilat) {
        this.toplamTahsilat = toplamTahsilat;
    }

    public BigDecimal getToplamGiderler() {
        return toplamGiderler;
    }

    public void setToplamGiderler(BigDecimal toplamGiderler) {
        this.toplamGiderler = toplamGiderler;
    }

    public BigDecimal getGenelDurum() {
        return genelDurum;
    }

    public void setGenelDurum(BigDecimal genelDurum) {
        this.genelDurum = genelDurum;
    }


}
