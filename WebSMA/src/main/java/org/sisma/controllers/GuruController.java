package org.sisma.controllers;


import org.sisma.dao.GuruDao;
import org.sisma.models.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GuruController {

	private GuruDao guruDao;

		
	@Autowired
	public void setGuruDao(GuruDao guruDao) {
		this.guruDao = guruDao;
	}
	
	@RequestMapping(value = "/createGuru", method = RequestMethod.POST)
	public String createRequest(Model model, Guru guru){
		model.addAttribute("siswa", guruDao.saveOrUpdate(guru));
		return "redirect:/smais/admin/entriGuru";
	}
 

}
