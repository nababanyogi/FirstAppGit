package org.sisma.controllers;


import org.sisma.dao.KelasDao;
import org.sisma.models.Kelas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class KelasController {

	private KelasDao kelasDao;

		
	@Autowired
	public void setKelasDao(KelasDao kelasDao) {
		this.kelasDao = kelasDao;
	}
	
	@RequestMapping(value = "/createKelas", method = RequestMethod.POST)
	public String createRequest(Model model, Kelas kelas){
		model.addAttribute("kelas", kelasDao.saveOrUpdate(kelas));
		return "redirect:/smais/admin/entriKelas";
	}
 

}
