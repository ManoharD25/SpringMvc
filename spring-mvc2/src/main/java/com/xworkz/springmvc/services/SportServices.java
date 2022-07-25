package com.xworkz.springmvc.services;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.springmvc.bean.SportBean;
import com.xworkz.springmvc.customexception.SportException;
import com.xworkz.springmvc.dto.SportDto;


@Component
public interface SportServices {


	
	public boolean validateSportData(SportDto sportDto) throws SportException;

	public boolean saveSportData(SportDto sportDto);

	public boolean validateSportNameService( String sportName);
	
	public SportDto searchBySportNameService(String sportName);

	public List<Object> getAllSportDataService();

	public Boolean deleteSportBeanService(String sportName);
	
	
}
