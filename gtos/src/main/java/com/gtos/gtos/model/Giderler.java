package com.gtos.gtos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "giderler")
public class Giderler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "gider_turu")
    String giderTuru;

    public BigDecimal getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(BigDecimal odenenTutar) {
        this.odenenTutar = odenenTutar;
    }

    @Column(name = "odenen_tutar")
    BigDecimal odenenTutar;
    @Column(name = "tarih")
    LocalDate tarih;

    public String getGiderTuru() {
        return giderTuru;
    }

    public void setGiderTuru(String giderTuru) {
        this.giderTuru = giderTuru;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }


}
