package com.gtos.gtos.repository;

import com.gtos.gtos.model.Randevular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RandevularRepository extends JpaRepository<Randevular,Long> {
    List<Randevular> findByRandevuTarihi(LocalDate tarih);

    List<Randevular> findByTelefonNumarasi(String telefonNumarasi);

    List<Randevular> findAllByOrderByRandevuTarihiAsc();



}
