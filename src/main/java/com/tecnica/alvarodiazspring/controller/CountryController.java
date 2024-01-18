package com.tecnica.alvarodiazspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tecnica.alvarodiazspring.model.CountryData;
import com.tecnica.alvarodiazspring.model.DataFromRestCountries;
import com.tecnica.alvarodiazspring.repository.CountryRepository;

@RestController
@RequestMapping("/api/v1/data/country")
public class CountryController {
	@Autowired
    private CountryRepository countryRepository;

    private static final String EXTERNAL_API_URL = "https://restcountries.com/v3.1/all?fields=name,population";
    
    @PostMapping
    public List<CountryData> savePopulationData() {
        RestTemplate restTemplate = new RestTemplate();
        DataFromRestCountries[] data = restTemplate.getForObject(EXTERNAL_API_URL, DataFromRestCountries[].class);

        for (DataFromRestCountries entry : data) {
            String country = entry.getName().getCommon();
            long population = entry.getPopulation();

            CountryData countryData = new CountryData();
            countryData.setCountry(country);
            countryData.setPopulation(population);
            countryRepository.save(countryData);
        }

        return (List<CountryData>) countryRepository.findAll();
    }

    @GetMapping
    public List<CountryData> getPopulationData() {
        return (List<CountryData>) countryRepository.findAll();
    }
}