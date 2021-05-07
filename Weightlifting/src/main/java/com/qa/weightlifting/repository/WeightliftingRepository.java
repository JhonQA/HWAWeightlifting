package com.qa.weightlifting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.weightlifting.domain.Weightlifting;

@Repository
public interface WeightliftingRepository extends JpaRepository<Weightlifting, Long>{

	
}
