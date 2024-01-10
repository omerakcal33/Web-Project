package com.gtos.gtos.controller;

import com.gtos.gtos.model.Giderler;
import com.gtos.gtos.model.HastaTahsilat;
import com.gtos.gtos.model.Randevular;
import com.gtos.gtos.model.dto.GenelDurumDTO;
import com.gtos.gtos.service.GenelDurumService;
import com.gtos.gtos.service.GiderlerService;
import com.gtos.gtos.service.HastaTahsilatService;
import com.gtos.gtos.service.RandevuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OdemeController {
    @Autowired
    HastaTahsilatService hastaTahsilatService;

    @Autowired
    GiderlerService giderlerService;

    @Autowired
    GenelDurumService genelDurumService;

    @PostMapping("/saveHastaTahsilat")
    public ResponseEntity<HastaTahsilat> saveHastaTahsilat(@RequestBody HastaTahsilat hastaTahsilat) {
        try {
            if (hastaTahsilat != null && hastaTahsilat.getTelefonNumarasi() != null) {
                List<HastaTahsilat> hastaTahsilatList = hastaTahsilatService.getOdemeByTelefonNo(hastaTahsilat.getTelefonNumarasi());
                if (CollectionUtils.isEmpty(hastaTahsilatList)) {
                    hastaTahsilatService.saveOdemeBilgileri(hastaTahsilat);
                    return new ResponseEntity<>(hastaTahsilat, HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>(hastaTahsilat, HttpStatus.NOT_ACCEPTABLE);
                }
            } else {
                return new ResponseEntity<>(hastaTahsilat, HttpStatus.CREATED);
            }


        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOdemeListByTelefonNumarasi/{telefon}")
    @ResponseBody
    public ResponseEntity<List<HastaTahsilat>> getOdemeListByTelefonNumarasi(@PathVariable String telefon) {
        try {
            List<HastaTahsilat> hastaTahsilatList = hastaTahsilatService.getOdemeByTelefonNo(telefon);

            if (hastaTahsilatList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hastaTahsilatList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getLatestOdemeListByTelefonNumarasi/{telefon}")
    @ResponseBody
    public ResponseEntity<List<HastaTahsilat>> getLatestOdemeList(@PathVariable String telefon) {
        try {
            HastaTahsilat hastaTahsilat = hastaTahsilatService.getLatestOdemeBilgileri(telefon);
            List<HastaTahsilat> hastaTahsilatList = new ArrayList<>();
            if (hastaTahsilat == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            hastaTahsilatList.add(hastaTahsilat);
            return new ResponseEntity<>(hastaTahsilatList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveOdeme")
    public ResponseEntity<HastaTahsilat> saveOdeme(@RequestBody HastaTahsilat hastaTahsilat) {
        try {
            if (hastaTahsilat != null) {
                hastaTahsilatService.saveOdemeBilgileri(hastaTahsilat);
                return new ResponseEntity<>(hastaTahsilat, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(hastaTahsilat, HttpStatus.NOT_ACCEPTABLE);
            }

        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveGider")
    public ResponseEntity<Giderler> saveGider(@RequestBody Giderler gider) {
        try {
            if (gider != null) {
               Giderler savedGider = giderlerService.saveGiderler(gider);
                return new ResponseEntity<>(savedGider, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(gider, HttpStatus.NOT_ACCEPTABLE);
            }

        } catch (DataIntegrityViolationException e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAylikGenelDurum/{tarih}")
    @ResponseBody
    public ResponseEntity<List<GenelDurumDTO>> getAylikGenelDurum(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tarih) {
        try {
                List<GenelDurumDTO> genelDurumDTOList = new ArrayList<>();
            GenelDurumDTO genelDurumDTO = genelDurumService.genelDurumDTO(tarih);
            genelDurumDTOList.add(genelDurumDTO);

            if (genelDurumDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(genelDurumDTOList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAylikGiderList/{tarih}")
    @ResponseBody
    public ResponseEntity<List<Giderler>> getAylikGiderList(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tarih) {
        try {

            List<Giderler> giderlerList = giderlerService.getAllGiderler(tarih);


            if (giderlerList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(giderlerList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getAylikTahsilatList/{tarih}")
    @ResponseBody
    public ResponseEntity<List<HastaTahsilat>> getAylikTahsilatList(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate tarih) {
        try {

            List<HastaTahsilat> hastaTahsilatList = hastaTahsilatService.getAllTahsilat(tarih);

            if (hastaTahsilatList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(hastaTahsilatList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
