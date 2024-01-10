package com.gtos.gtos.service;

import com.gtos.gtos.model.Hastalar;
import com.gtos.gtos.model.Randevular;
import com.gtos.gtos.repository.HastalarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastalarService {

    @Autowired
    HastalarRepository hastalarRepository;

    public Hastalar saveHastalar(Hastalar hastalar){
        return hastalarRepository.save(hastalar);
    }

    public List<Hastalar> getAllHastalar( ){
        return hastalarRepository.findAll();
    }

    public Hastalar getHastalarByTelefonNumarasi(String telefonNumarasi){
        return hastalarRepository.findByTelefonNumarasi(telefonNumarasi);

    }

}
