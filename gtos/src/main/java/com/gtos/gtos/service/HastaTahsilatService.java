package com.gtos.gtos.service;

import com.gtos.gtos.model.Giderler;
import com.gtos.gtos.model.HastaTahsilat;
import com.gtos.gtos.repository.HastaTahsilatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HastaTahsilatService {
    @Autowired
    HastaTahsilatRepository hastaTahsilatRepository;

    public List<HastaTahsilat> getOdemeByTelefonNo(String telefonNo){
        return hastaTahsilatRepository.findByTelefonNumarasiOrderByTarihDesc(telefonNo);
    }


    public HastaTahsilat saveOdemeBilgileri(HastaTahsilat hastaTahsilat){
        return hastaTahsilatRepository.save(hastaTahsilat);
    }

    public HastaTahsilat getLatestOdemeBilgileri(String telefonNo){
        return hastaTahsilatRepository.findTopByTelefonNumarasiOrderByTarihDesc(telefonNo);
    }

    public List<HastaTahsilat> getAllTahsilat(LocalDate tarih){
        LocalDate baslangicTarih = tarih.withDayOfMonth(1);
        LocalDate bitisTarih = tarih.withDayOfMonth(31);
        return hastaTahsilatRepository.findByTarihBetweenOrderByTarihDesc(baslangicTarih,bitisTarih);
    }
}
