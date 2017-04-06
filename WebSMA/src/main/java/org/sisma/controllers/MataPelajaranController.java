package org.sisma.controllers;


import org.sisma.dao.MataPelajaranDao;
import org.sisma.models.MataPelajaran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MataPelajaranController {

	private MataPelajaranDao mataPelajaranDao;

		
	@Autowired
	public void setKelasDao(MataPelajaranDao mataPelajaranDao) {
		this.mataPelajaranDao = mataPelajaranDao;
	}
	
	@RequestMapping(value = "/createMataPelajaran", method = RequestMethod.POST)
	public String createRequest(Model model, MataPelajaran mataPelajaran){
		model.addAttribute("matapelajaran", mataPelajaranDao.saveOrUpdate(mataPelajaran));
		return "redirect:/smais/admin/entriMataPelajaran";
	}
 
}
