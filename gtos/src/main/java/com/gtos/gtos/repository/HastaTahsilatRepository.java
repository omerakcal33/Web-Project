package com.gtos.gtos.repository;

import com.gtos.gtos.model.Giderler;
import com.gtos.gtos.model.HastaTahsilat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface HastaTahsilatRepository extends JpaRepository<HastaTahsilat, String> {

    List<HastaTahsilat> findByTelefonNumarasiOrderByTarihDesc(String telefoNumarasi);

    HastaTahsilat findTopByTelefonNumarasiOrderByTarihDesc(String telefoNumarasi);

    @Query("SELECT SUM(m.tahsilat) FROM HastaTahsilat m where m.tarih >= :baslangicTarih and m.tarih <= :bitisTarih")
    BigDecimal getAllTahsilatForGivenMonth(@Param("baslangicTarih") LocalDate baslangicTarih, @Param("bitisTarih") LocalDate bitisTarih);

    List<HastaTahsilat> findByTarihBetweenOrderByTarihDesc(LocalDate baslangic, LocalDate bitis);

}
