package com.gtos.gtos.service;

import com.gtos.gtos.model.dto.GenelDurumDTO;
import com.gtos.gtos.repository.GiderlerRepository;
import com.gtos.gtos.repository.HastaTahsilatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class GenelDurumService {
    @Autowired
    GiderlerRepository giderlerRepository;

    @Autowired
    HastaTahsilatRepository hastaTahsilatRepository;

    public GenelDurumDTO genelDurumDTO(LocalDate tarih) {
        LocalDate baslangicTarih = tarih.withDayOfMonth(1);
        LocalDate bitisTarih = tarih.withDayOfMonth(31);
        BigDecimal aylikToplamGiderler = giderlerRepository.getAllOdemeForGivenMonth(baslangicTarih, bitisTarih);
        BigDecimal aylikToplamGelirler = hastaTahsilatRepository.getAllTahsilatForGivenMonth(baslangicTarih, bitisTarih);
        BigDecimal aylikGenelDurum = aylikToplamGelirler.subtract(aylikToplamGiderler);

        GenelDurumDTO genelDurumDTO = new GenelDurumDTO();
        genelDurumDTO.setGenelDurum(aylikGenelDurum);
        genelDurumDTO.setToplamGiderler(aylikToplamGiderler);
        genelDurumDTO.setToplamTahsilat(aylikToplamGelirler);

        return genelDurumDTO;
    }
}
