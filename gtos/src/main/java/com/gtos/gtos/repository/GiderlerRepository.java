package com.gtos.gtos.repository;

import com.gtos.gtos.model.Giderler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface GiderlerRepository extends JpaRepository<Giderler,Long> {
    @Query("SELECT SUM(m.odenenTutar) FROM Giderler m where m.tarih >= :baslangicTarih and m.tarih <= :bitisTarih")
    BigDecimal getAllOdemeForGivenMonth(@Param("baslangicTarih") LocalDate baslangicTarih, @Param("bitisTarih") LocalDate bitisTarih);

    List<Giderler> findByTarihBetweenOrderByTarihDesc(LocalDate baslangic, LocalDate bitis);
}
