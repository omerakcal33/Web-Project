package com.gtos.gtos.controller;

import com.gtos.gtos.model.Hastalar;
import com.gtos.gtos.service.HastalarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.UniqueConstraint;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class HastalarController {

    @Autowired
    HastalarService hastalarService;

    @PostMapping("/saveHasta")
    public ResponseEntity<Hastalar> saveHasta(@RequestBody Hastalar hasta) {
        try {
            Hastalar hastalar = hastalarService.saveHastalar(hasta);
            return new ResponseEntity<>(hastalar, HttpStatus.CREATED);

        }catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateHasta")
    public ResponseEntity<Hastalar> updateHasta(@RequestBody Hastalar hasta) {
        try {
            if(hasta != null){
                Hastalar updatedHasta = hastalarService.getHastalarByTelefonNumarasi(hasta.getTelefonNumarasi());
                updatedHasta.setAdress(hasta.getAdress());
                updatedHasta.setAdSoyad(hasta.getAdSoyad());
                updatedHasta.setGerekenSeans(hasta.getGerekenSeans());
                updatedHasta.setSikayet(hasta.getSikayet());
                updatedHasta.setOdenecekTutar(hasta.getOdenecekTutar());
                updatedHasta.setTelefonNumarasi(hasta.getTelefonNumarasi());
                updatedHasta.setKalanSeans(hasta.getKalanSeans());
                updatedHasta.setYas(hasta.getYas());
                updatedHasta.setTeshis(hasta.getTeshis());
                Hastalar hastalar = hastalarService.saveHastalar(updatedHasta);
                return new ResponseEntity<>(hastalar, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllHastalar")
    public ResponseEntity<List<Hastalar>> getAllHasta() {
        try {
            List<Hastalar> hastalar = hastalarService.getAllHastalar();

            if (hastalar.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hastalar, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getHastaByTelefonNumarasi")
    public ResponseEntity<Hastalar> getHastaByTelefonNumarsi(@RequestBody String telefonNumarasi) {
        try {
            Hastalar hastalar = hastalarService.getHastalarByTelefonNumarasi(telefonNumarasi);
            if (hastalar==null) {
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hastalar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
