package org.sisma.controllers;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.sisma.dao.AkunDao;
import org.sisma.dao.RequestDao;
import org.sisma.models.Akun;
import org.sisma.models.Guru;
import org.sisma.models.Kelas;
import org.sisma.models.MataPelajaran;
import org.sisma.models.Pengumuman;
import org.sisma.models.Request;
import org.sisma.models.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private AkunDao aDao;
	private RequestDao rDao;
	private Akun akunLogin;

	@Autowired
	public void setuDao(AkunDao aDao) {
		this.aDao = aDao;
	}
	@Autowired
	public void setrDao(RequestDao rDao) {
		this.rDao = rDao;
	}
	
	@RequestMapping("/login")
	public String index(Model model) {
		model.addAttribute("akun", new Akun());
		model.addAttribute("akunLogin",new Akun());
		return "login";
	}
	
	

	@RequestMapping("/smais/siswa")
	public String homeMahasiswa(Model model) {
		Request request = new Request();
		request.setId_mahasiswa(akunLogin.getId());
		request.setNama_mahasiswa(akunLogin.getUsername());
		request.setStatus("NO");
		model.addAttribute("request", request);
		model.addAttribute("allRequest", rDao.getAllRequestByIdMahasiswa(akunLogin.getId()));
		model.addAttribute("akunLogin",akunLogin);
		return "homeSiswa";
	}

	@RequestMapping("/smais/duktek")
	public String homeDuktek(Model model) {
		model.addAttribute("allRequest",rDao.getAllRequestByStatus("NO"));
		model.addAttribute("akunLogin",akunLogin);
		return "homeDuktek";
	}

	@RequestMapping("/smais/admin")
	public String homeAdmin(Model model) {
		Pengumuman pengumuman = new Pengumuman();
		model.addAttribute("pengumuman", pengumuman);
		model.addAttribute("akunLogin",akunLogin);
		return "adminhome";
	}
	
	@RequestMapping("/smais/admin/entriSiswa")
	public String createSiswa(Model model) {
		Siswa siswa = new Siswa();
		model.addAttribute("siswa", siswa);
		model.addAttribute("akunLogin",akunLogin);
		return "entriSiswa";
	}

	@RequestMapping("/smais/admin/entriGuru")
	public String createGuru(Model model) {
		Guru guru = new Guru();
		model.addAttribute("guru", guru);
		model.addAttribute("akunLogin",akunLogin);
		return "entriGuru";
	}
	
	@RequestMapping("/smais/admin/entriKelas")
	public String createKelas(Model model) {
		Kelas kelas = new Kelas();
		kelas.setIdWali("NULL");
		model.addAttribute("kelas", kelas);
		model.addAttribute("akunLogin",akunLogin);
		return "entriKelas";
	}

	@RequestMapping("/smais/admin/entriMataPelajaran")
	public String createMataPelajaran(Model model) {
		MataPelajaran mataPelajaran = new MataPelajaran();
		model.addAttribute("matapelajaran", mataPelajaran);
		model.addAttribute("akunLogin",akunLogin);
		return "entriMataPelajaran";
	}	
	
	@RequestMapping("/smais/admin/assignWali")
	public String assignWali(Model model) {
		Kelas kelas = new Kelas();
		model.addAttribute("kelas", kelas);
		model.addAttribute("akunLogin",akunLogin);
		return "assignWali";
	}
	
	@RequestMapping(value = "/createAkun", method = RequestMethod.POST)
	public String saveOrUpdateAkun(Model model, Akun akun) {
		model.addAttribute("akun", aDao.saveOrUpdate(akun));
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		if(aDao.login(username, password) != null){
			request.getSession().setAttribute("akunLogin", aDao.login(username, password));
			akunLogin = (Akun) request.getSession().getAttribute("akunLogin");
			if (akunLogin.getRole().equals("Siswa")) {
				return "redirect:/smais/siswa";
			} else if (akunLogin.getRole().equals("Guru")) {
				return "redirect:/smais/duktek";
			} else if (akunLogin.getRole().equals("Admin")) {			
				return "redirect:/smais/admin";
			} 
		}		
		return "redirect:/login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("akunLogin");
		return "redirect:/login";
	}
	
}
