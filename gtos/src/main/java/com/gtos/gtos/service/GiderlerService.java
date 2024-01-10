package com.gtos.gtos.service;

import com.gtos.gtos.model.Giderler;
import com.gtos.gtos.repository.GiderlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GiderlerService {
    @Autowired
    GiderlerRepository giderlerRepository;
    public Giderler saveGiderler(Giderler giderler){
        return giderlerRepository.save(giderler);

    }

    public List<Giderler> getAllGiderler(LocalDate tarih){
        LocalDate baslangicTarih = tarih.withDayOfMonth(1);
        LocalDate bitisTarih = tarih.withDayOfMonth(31);
        return giderlerRepository.findByTarihBetweenOrderByTarihDesc(baslangicTarih,bitisTarih);
    }
}
