package com.gtos.gtos.controller;

import com.gtos.gtos.model.Hastalar;
import com.gtos.gtos.model.Randevular;
import com.gtos.gtos.repository.RandevularRepository;
import com.gtos.gtos.service.RandevuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RandevuController {

    @Autowired
    RandevuService randevuService;

    @PostMapping("/saveRandevu")
    public ResponseEntity<Randevular> saveHasta(@RequestBody Randevular randevular) {
        try {
            Randevular randevu = randevuService.saveHastalar(randevular);
            return new ResponseEntity<>(randevu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllRandevular")
    public ResponseEntity<List<Randevular>> getAllRandevular() {
        try {
            List<Randevular> randevular = randevuService.getAllRandevular(LocalDate.now());

            if (randevular.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(randevular, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllRandevuList")
    public ResponseEntity<List<Randevular>> getAllRandevuList() {
        try {
            List<Randevular> randevular = randevuService.getAllRandevuList();

            if (randevular.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(randevular, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getRandevuByTelefonNumarasi/{telefon}")
    @ResponseBody
    public ResponseEntity<List<Randevular>> getRandevuByTelefonNumarasi(@PathVariable String telefon) {
        try {
            List<Randevular> randevular = randevuService.getRandevuByTelefonNumarasi(telefon);

            if (randevular.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(randevular, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllRandevuByTarih/{tarih}")
    @ResponseBody
    public ResponseEntity<List<Randevular>> getAllRandevuByTarih(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tarih) {
        try {
            List<Randevular> randevular = randevuService.getAllRandevular(tarih);

            if (randevular.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(randevular, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
