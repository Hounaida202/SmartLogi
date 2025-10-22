package com.smartlogi.repositories;
import com.smartlogi.entities.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisRepository extends JpaRepository <Colis,Long> {
}
