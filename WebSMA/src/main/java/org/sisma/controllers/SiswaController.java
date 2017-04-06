package org.sisma.controllers;


import org.sisma.dao.SiswaDao;
import org.sisma.models.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SiswaController {

	private SiswaDao siswaDao;

		
	@Autowired
	public void setSiswaDao(SiswaDao siswaDao) {
		this.siswaDao = siswaDao;
	}
	
	@RequestMapping(value = "/createSiswa", method = RequestMethod.POST)
	public String createRequest(Model model, Siswa siswa){
		model.addAttribute("siswa", siswaDao.saveOrUpdate(siswa));
		return "redirect:/smais/admin/entriSiswa";
	}

	


}
