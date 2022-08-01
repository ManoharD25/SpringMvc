package com.xworkz.springmvc.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.xworkz.springmvc.bean.SportBean;
import com.xworkz.springmvc.customexception.SportException;
import com.xworkz.springmvc.dto.SportDto;
import com.xworkz.springmvc.services.SportServiceImpl;
import com.xworkz.springmvc.services.SportServices;

//@RequestMapping("/")
@Controller
public class SportController {

	@Autowired
	private SportServices sportServices;

	public SportController() {
		System.out.println(getClass().getSimpleName() + " bean created");
	}

	@RequestMapping("/getRCBImage.sports")
	public String getRCBImage() {
		System.out.println("getRCBImage() started");
		return "RCB best pic";

	}

	@RequestMapping(value = "/getRegistrationPage.sports")
	public String getRegistrationPage() {
		System.out.println("getRegistration() started");
		return "Registration";

	}

	@RequestMapping(value = "/readRegistrationPage.sports", method = RequestMethod.POST)
	public String readWellComePage(@ModelAttribute SportDto sportDto, Model model) throws SportException {

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

		return "Registration";
	}

	@RequestMapping(value = "/searchBySportName.sports", method = RequestMethod.POST)
	public String searchBySportName(@RequestParam String sportName, Model model) {
		System.out.println("searchBySportName() started " + sportName);

		boolean isSportNamevalid = this.sportServices.validateSportNameService(sportName);

		if (isSportNamevalid) {

			System.out.println(sportName + " is valid");

			SportDto sportDtoController = this.sportServices.searchBySportNameService(sportName);

			if (sportDtoController != null) {

				model.addAttribute("sportName", sportDtoController.getSportName());
				model.addAttribute("noOfPlayers", sportDtoController.getNoOfPlayers());
				model.addAttribute("captainName", sportDtoController.getCaptainName());
				model.addAttribute("sportCoach",  sportDtoController.getSportCoach() );
				model.addAttribute("sheduledDate", sportDtoController.getSheduledDate());
				
				model.addAttribute("searched", " Search reasult");
			} else {
				System.out.println("sportDto at Controller is empty ");

				model.addAttribute("notsearched", " Search reasult not found  ");
			}

		} else {
			model.addAttribute("notsearched", " Invalid name  " + sportName);
		}

		return "Registration";

	}

	@RequestMapping(value = "/getAllSportData.sports")
	public String getAllSportData(Model model) {
		System.out.println("getAllSportData() started");

		List<Object> listController = this.sportServices.getAllSportDataService();

		for (Object object : listController) {
			System.out.println(object);
		}

		model.addAttribute("listController", listController);

		return "Registration";
	}

	@RequestMapping(value = "/deleteSportBeanBySportName.sports", method = RequestMethod.POST)
	public String deleteSportBeanBySportName(@RequestParam String sportName, Model model) {
		System.out.println("deleteSportBeanBySportName() started");

		Boolean isSportBeanDeleted = this.sportServices.deleteSportBeanService(sportName);
		if (isSportBeanDeleted) {
			model.addAttribute("delete", " sportBean is deleted successfully  ");

		} else {
			model.addAttribute("Notdelete", " sportBean  din't deleted");
		}
		return "Registration";

	}

	@RequestMapping(value = "/updateSportBeanBySportName.sports", method = RequestMethod.POST)
	public String updateSportBeanBySportName(@ModelAttribute SportDto sportDto, Model model) {
		System.out.println("updateSportBeanBySportName() started");

		
		Boolean isSportBeanDeleted = this.sportServices.updateSportBeanService(sportDto);
		if (isSportBeanDeleted) {
			model.addAttribute("updated", " sportBean is updated successfully  ");

		} else {
			Map<String, String> hashMapCon = SportServiceImpl.hashMap;

			model.addAttribute("errorSportName", hashMapCon.get("SportName"));
			model.addAttribute("errorNoOfPlayers", hashMapCon.get("NoOfPlayers"));
			model.addAttribute("errorCaptainName", hashMapCon.get("CaptainName"));
			model.addAttribute("errorSportCoach", hashMapCon.get("SportCoach"));
			model.addAttribute("errorSheduledDate", hashMapCon.get("SheduledDate"));
			
			model.addAttribute("notupdated", " sportBean  din't updated  ");
		}
		return "Registration";

	}

}
