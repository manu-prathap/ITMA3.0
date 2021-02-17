package com.Itma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Itma.model.DoctorSpecialization;

@Repository
public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization,Long> {

}
