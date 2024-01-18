package com.tecnica.alvarodiazspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecnica.alvarodiazspring.model.CountryData;

@Repository
public interface CountryRepository extends CrudRepository<CountryData, String> {

}
