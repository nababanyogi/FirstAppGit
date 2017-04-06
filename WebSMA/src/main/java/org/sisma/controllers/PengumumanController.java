package org.sisma.controllers;

import org.sisma.dao.PengumumanDao;
import org.sisma.models.Pengumuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PengumumanController {

	private PengumumanDao pengumumanDao;

	@Autowired
	public void setPengumumanDao(PengumumanDao pengumumanDao) {
		this.pengumumanDao = pengumumanDao;
	
	}
	
	
	@RequestMapping(value = "/createPengumuman", method = RequestMethod.GET)
	public String  TampilkanPengumuman(Model model){
		model.addAttribute("pengumuman", new Pengumuman());
		return "adminhome";
	}
	
	
	
	@RequestMapping(value = "/createPengumuman", method = RequestMethod.POST)
	public String  createPengumuman(Model model, Pengumuman pengumuman){
		model.addAttribute("pengumuman", pengumumanDao.saveOrUpdate(pengumuman));
		return "redirect:/smais/admin";
	}


	

}
