package com.gtos.gtos.repository;

import com.gtos.gtos.model.Hastalar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HastalarRepository extends JpaRepository<Hastalar,Long> {
    Hastalar findByTelefonNumarasi(String telefonNumarasi);

}
