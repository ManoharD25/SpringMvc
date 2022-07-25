package com.xworkz.springmvc.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.xworkz.springmvc.bean.SportBean;


@Component
public interface SportDao {

	public boolean saveSessionFactory(SportBean sportBean);
	 
	public SportBean searchBySportName(String  sportName);

	public List<Object> getAllSportDataDaoImpl();

	public Boolean deleteSportBeanBySportName(String sportName);
}
