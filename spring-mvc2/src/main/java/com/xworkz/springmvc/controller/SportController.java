package com.xworkz.springmvc.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.springmvc.bean.SportBean;
import com.xworkz.springmvc.customexception.SportException;
import com.xworkz.springmvc.dto.SportDto;
import com.xworkz.springmvc.services.SportServiceImpl;
import com.xworkz.springmvc.services.SportServices;

@RequestMapping("/")
@Component
public class SportController {

	@Autowired
	private SportServices sportServices;

	public SportController() {
		System.out.println(getClass().getSimpleName() + " bean created");
	}

	@RequestMapping("/getRCBImage")
	public String getRCBImage() {
		System.out.println("getRCBImage() started");
		return "WEB-INF/RCB best pic.jpg";

	}

	@RequestMapping(value = "/getRegistrationPage")
	public String getRegistrationPage() {
		System.out.println("getRegistration() started");
		return "/WEB-INF/Registration.jsp";

	}

	@RequestMapping(value = "/readRegistrationPage")
	public String readWellComePage(@ModelAttribute SportDto sportDto, Model model) throws SportException {

		System.out.println("readRegistrationPage() started");
		System.out.println("sportName : " + sportDto.getSportName());
		System.out.println("noOfPlayers : " + sportDto.getNoOfPlayers());
		System.out.println("captainName : " + sportDto.getCaptainName());
		System.out.println("sportCoach : " + sportDto.getSportCoach());
		System.out.println("sheduledDate : " + sportDto.getSheduledDate());

		boolean isSportServiceValid = this.sportServices.validateSportData(sportDto);

		if (isSportServiceValid) {
			System.out.println("Services Validated the Sport Data");

			boolean isSportBeanSaved = this.sportServices.saveSportData(sportDto);

			if (isSportBeanSaved) {
				System.out.println("Saved Sport  Data");

			} else {
				System.out.println("Saved Sport  Data");
			}

		} else {
			System.out.println("Services In-validated the Sport Data");
			Map<String, String> hashMapCon = SportServiceImpl.hashMap;

			model.addAttribute("errorSportName", hashMapCon.get("SportName"));
			model.addAttribute("errorNoOfPlayers", hashMapCon.get("NoOfPlayers"));
			model.addAttribute("errorCaptainName", hashMapCon.get("CaptainName"));
			model.addAttribute("errorSportCoach", hashMapCon.get("SportCoach"));
			model.addAttribute("errorSheduledDate", hashMapCon.get("SheduledDate"));
		}

		return "/WEB-INF/Registration.jsp";
	}

	@RequestMapping("/searchBySportName")
	public String searchBySportName(@RequestParam String sportName, Model model) {
		System.out.println("searchBySportName() started " + sportName);

		boolean isSportNamevalid = this.sportServices.validateSportNameService(sportName);

		if (isSportNamevalid) {

			System.out.println(sportName + " is valid");

			SportDto sportDtoController = this.sportServices.searchBySportNameService(sportName);

			if (sportDtoController != null) {

				model.addAttribute("SportName", sportDtoController.getSportName());
				model.addAttribute("CaptainName", sportDtoController.getCaptainName());
				model.addAttribute("SportCoach", sportDtoController.getSportCoach());
				model.addAttribute("SheduledDate", sportDtoController.getSheduledDate());
				model.addAttribute("NoOfPlayers", sportDtoController.getNoOfPlayers());

			} else {
				System.out.println("sportBeanController is empty ");

				model.addAttribute("searchSportName ", " Search reasult not found  " + sportName);
			}

		} else {
			model.addAttribute("searchSportName ", " Invalid name  " + sportName);
		}

		return "/WEB-INF/Registration.jsp";

	}

	@RequestMapping(value = "/getAllSportData")
	public String getAllSportData(Model model) {
		System.out.println("getAllSportData() started");

		List<Object> listController = this.sportServices.getAllSportDataService();

		for (Object object : listController) {
			System.out.println(object);
		}

		model.addAttribute("listController", listController);

		System.out.println("getAllSportData() ended");

		return "/WEB-INF/Registration.jsp";

	}

	@RequestMapping(value = "/deleteSportBeanBySportName")
	public String deleteSportBeanBySportName(@RequestParam String sportName, Model model) {
		System.out.println("deleteSportBeanBySportName() started");

		Boolean isSportBeanDeleted = this.sportServices.deleteSportBeanService(sportName);
		if (isSportBeanDeleted) {
			model.addAttribute("success", " sportName is deleted successfully  ");

		} else {
			model.addAttribute("unsuccess", " sportName is din't deleted  ");
		}
		return "/WEB-INF/Registration.jsp";

	}
}
