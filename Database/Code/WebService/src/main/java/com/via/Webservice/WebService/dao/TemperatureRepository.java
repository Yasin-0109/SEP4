package com.via.Webservice.WebService.dao;

import org.springframework.data.repository.CrudRepository;

import com.via.Webservice.WebService.model.Temperature;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {

}