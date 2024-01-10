package com.gtos.gtos.service;

import com.gtos.gtos.model.Hastalar;
import com.gtos.gtos.model.Randevular;
import com.gtos.gtos.repository.RandevularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RandevuService {
    @Autowired
    RandevularRepository randevularRepository;

    public Randevular saveHastalar(Randevular randevular){
        return randevularRepository.save(randevular);
    }

    public List<Randevular> getAllRandevular(LocalDate randevuTarihi){
        return randevularRepository.findByRandevuTarihi(randevuTarihi);
    }

    public List<Randevular> getRandevuByTelefonNumarasi(String telefonNumarasi){
        return randevularRepository.findByTelefonNumarasi(telefonNumarasi);
    }

    public List<Randevular> getAllRandevuList(){
        return randevularRepository.findAllByOrderByRandevuTarihiAsc();
    }


}
