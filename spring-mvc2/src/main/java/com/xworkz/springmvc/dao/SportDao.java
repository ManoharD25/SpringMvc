package com.xworkz.springmvc.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.springmvc.bean.SportBean;

@Repository
public interface SportDao {

	public boolean saveSessionFactory(SportBean sportBean);
	 
	public SportBean searchBySportName(String  sportName);

	public List<Object> getAllSportDataDaoImpl();

	public Boolean deleteSportBeanBySportName(String sportName);

	public boolean updateSportBeanDao(SportBean sportBean);

}
