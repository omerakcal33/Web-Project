package com.gtos.gtos.model;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "hastalar")
public class Hastalar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "adSoyad")
    private String adSoyad;
    @Column(name = "telefonNumarasi",unique = true)
    private String telefonNumarasi;
    @Column(name = "yas")
    private int yas;
    @Column(name = "adress")
    private String adress;
    @Column(name = "gerekenSeans")
    private int gerekenSeans;
    @Column(name = "kalanSeans")
    private int kalanSeans;
    @Column(name = "odenecekTutar")
    private BigDecimal odenecekTutar;
    @Column(name = "teshis")
    private String teshis;

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

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getGerekenSeans() {
        return gerekenSeans;
    }

    public void setGerekenSeans(int gerekenSeans) {
        this.gerekenSeans = gerekenSeans;
    }

    public int getKalanSeans() {
        return kalanSeans;
    }

    public void setKalanSeans(int kalanSeans) {
        this.kalanSeans = kalanSeans;
    }

    public BigDecimal getOdenecekTutar() {
        return odenecekTutar;
    }

    public void setOdenecekTutar(BigDecimal odenecekTutar) {
        this.odenecekTutar = odenecekTutar;
    }

    public String getTeshis() {
        return teshis;
    }

    public void setTeshis(String teshis) {
        this.teshis = teshis;
    }

    public String getSikayet() {
        return sikayet;
    }

    public void setSikayet(String sikayet) {
        this.sikayet = sikayet;
    }

    @Column(name = "sikayet")
    private String sikayet;
}
