package com.xworkz.springmvc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.springmvc.bean.SportBean;
import com.xworkz.springmvc.customexception.SportException;
import com.xworkz.springmvc.dao.SportDao;
import com.xworkz.springmvc.dao.SportDaoImpl;
import com.xworkz.springmvc.dto.SportDto;

@Component
public class SportServiceImpl implements SportServices {

	@Autowired
	private SportDao sportDao;

	public SportServiceImpl() {
		System.out.println(getClass().getSimpleName() + " bean created");
	}

	public static Map<String, String> hashMap = new HashMap<String, String>();

	public boolean validateSportData(SportDto sportDto) throws SportException {
		boolean flag = false;

		hashMap = new HashMap<String, String>();
		try {
			if (!StringUtils.isBlank(sportDto.getSportName())) {
				System.out.println("SportName is valid");
				flag = true;
			} else {
				hashMap.put("SportName", "SportName is Invalid");
				flag = false;
				return flag;
			}

			if (sportDto.getNoOfPlayers() > 0) {
				System.out.println("NoOfPlayers is valid");
				flag = true;

			} else {
				hashMap.put("NoOfPlayers", "NoOfPlayers is Invalid");
				flag = false;
				return flag;
			}

			if (!StringUtils.isBlank(sportDto.getCaptainName())) {
				hashMap.put("CaptainName", "CaptainName is Invalid");
				flag = true;
			} else {
				System.out.println("captainName is Invalid");
				flag = false;
				return flag;
			}

			if (!StringUtils.isBlank(sportDto.getSportCoach())) {
				System.out.println("SportCoach is valid");
				flag = true;
			} else {
				hashMap.put("SportCoach", "SportCoach is Invalid");
				flag = false;
				return flag;
			}

			if (!StringUtils.isBlank(sportDto.getSheduledDate())) {
				System.out.println("SheduledDate is Valid");
				flag = true;
			} else {
				hashMap.put("SheduledDate", "SheduledDate is Invalid");
				flag = false;
				return flag;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public boolean saveSportData(SportDto sportDto) {
		boolean flag = false;

		System.out.println("saveSportData() started \n");
		SportBean sportBean = new SportBean();
		BeanUtils.copyProperties(sportDto, sportBean);

		boolean isSportBeanSaved = this.sportDao.saveSessionFactory(sportBean);
		if (isSportBeanSaved) {
			System.out.println("Sport Bean Saved ");
			flag = true;
		} else {

			System.out.println("Sport Bean Not saved ");
			flag = false;
			return flag;
		}
		return flag;
	}

	public boolean validateSportNameService(String sportName) {
		System.out.println("validateSportNameService() started ");

		boolean issportName = false;
		try {
			issportName = (!StringUtils.isBlank(sportName) ? true : false);
			System.out.println("issportName is " + issportName);

			return issportName;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return issportName;
	}

	public SportDto searchBySportNameService(String sportName) {
		System.out.println("searchBySportNameService() started");
		SportDto sportDtoService = null;
		try {
			SportBean sportBean = this.sportDao.searchBySportName(sportName);
			if (sportBean != null) {
				sportDtoService = new SportDto();
				BeanUtils.copyProperties(sportBean, sportDtoService);
				return sportDtoService;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sportDtoService;
	}

	public List<Object> getAllSportDataService() {
		System.out.println("getAllSportDataService() started");
		List<Object> listService = null;

		List<Object> listBeanservice = this.sportDao.getAllSportDataDaoImpl();
		System.out.println("\n To check the data  from DaoImpl method " + listBeanservice);

		if (listBeanservice != null) {
			listService = new ArrayList<Object>();
			listService = listBeanservice;

//			for (Object sportBeanService : listBeanservice) {
//				listService.add(sportBeanService);
			System.out.println(listService);
//			}

		} else {
			System.out.println("listBeanservice is null at getAllSportDataService()");
		}

		System.out.println("getAllSportDataService() ended");
		return listService;
	}

	public Boolean deleteSportBeanService(String sportName) {

		boolean flag = false;
		try {
			Boolean isSportBeanDeleteServ = this.sportDao.deleteSportBeanBySportName(sportName);
			if (isSportBeanDeleteServ) {
				flag = true;
				
			} else {

				System.out.println("Sport Bean Not deleted ");
				flag = false;
				return flag;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return flag;
	}

}
