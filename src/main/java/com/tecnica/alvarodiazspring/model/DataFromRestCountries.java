package com.tecnica.alvarodiazspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataFromRestCountries {
    @JsonProperty("name")
    private Name name;

    @JsonProperty("population")
    private long population;

    public Name getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public static class Name {
        @JsonProperty("common")
        private String common;

        public String getCommon() {
            return common;
        }
    }
}