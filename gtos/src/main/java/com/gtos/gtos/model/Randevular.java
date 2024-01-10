package com.gtos.gtos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "randevular")
public class Randevular {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "adSoyad")
    private String adSoyad;

    @Column(name = "telefonNumarasi")
    private String telefonNumarasi;
    @Column(name = "randevuTarihi")
    private LocalDate randevuTarihi;
    @Column(name = "randevuSaati")
    private String randevuSaati;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public LocalDate getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setRandevuTarihi(LocalDate randevuTarihi) {
        this.randevuTarihi = randevuTarihi;
    }

    public String getRandevuSaati() {
        return randevuSaati;
    }

    public void setRandevuSaati(String randevuSaati) {
        this.randevuSaati = randevuSaati;
    }



}
