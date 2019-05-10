package com.via.Webservice.WebService.service.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.via.Webservice.WebService.dao.Warning.WarningRepository;
import com.via.Webservice.WebService.model.Warning;

@Service
public class WarningService {
	
	@Autowired
	WarningRepository dao;
	public Iterable<Warning> findAllWarning() {
		return dao.findAll();
	}
}