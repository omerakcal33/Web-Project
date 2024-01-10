package com.gtos.gtos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "hastatahsilat")
public class HastaTahsilat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "adSoyad")
    private String adSoyad;

    @Column(name="telefon_numarasi")
    private String telefonNumarasi;

    @Column(name="tahsilat")
    private BigDecimal tahsilat;


    @Column(name="toplam_borc")
    private BigDecimal toplamBorc;

    @Column(name="kalan_borc")
    private BigDecimal kalanBorc;

    @Column(name="tarih")
    private LocalDate tarih;

    public LocalDate getTarih() {
        return tarih;
    }

    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }


    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public BigDecimal getTahsilat() {
        return tahsilat;
    }

    public void setTahsilat(BigDecimal tahsilat) {
        this.tahsilat = tahsilat;
    }



    public BigDecimal getKalanBorc() {
        return kalanBorc;
    }

    public void setKalanBorc(BigDecimal kalanBorc) {
        this.kalanBorc = kalanBorc;
    }

    public BigDecimal getToplamBorc() {
        return toplamBorc;
    }

    public void setToplamBorc(BigDecimal toplamBorc) {
        this.toplamBorc = toplamBorc;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
