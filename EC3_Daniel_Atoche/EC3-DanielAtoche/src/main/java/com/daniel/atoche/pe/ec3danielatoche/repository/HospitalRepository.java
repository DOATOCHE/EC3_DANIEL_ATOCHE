package com.daniel.atoche.pe.ec3danielatoche.repository;

import org.springframework.stereotype.Repository;

import com.daniel.atoche.pe.ec3danielatoche.model.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
