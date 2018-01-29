package com.inabif.controller;

import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inabif.constant.ViewConstant;
import com.inabif.model.FeriadoModel;
//import com.inabif.constant.ViewConstant;
import com.inabif.service.FeriadoService;





@Controller
@RequestMapping("/feriado")
public class FeriadoController {
	


	private static final Log LOG = LogFactory.getLog(FeriadoController.class);
	@Autowired
	@Qualifier("feriadoServiceImpl")
	private FeriadoService feriadoService;
	
	protected HttpServletRequest request;
	
	public void execute() {
		
	}
	
	
	@GetMapping("/listar")
	public ModelAndView showFeriados() {
		ModelAndView mav = new ModelAndView(ViewConstant.FERIADOS);
		//mav.addObject("feriados",feriadoService.findFeriadosByYear(2017));
		//LOG.info("METHOD: showFeriados() --PARMS:" +feriadoService.findFeriadosByYear(2017));
		//mav.addObject("sistema",ViewConstant.SISTEMA_TITULO);
	
		//LOG.info("sesion"+sesion.getAttribute("usuarioSession"));
		return mav;
		
	}
	
	@GetMapping("/cancel")
	private String cancel() {
		//model.addAttribute("contactModel",new ContactModel());
		return ViewConstant.FERIADOS;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id",required=true) int id) {
		feriadoService.removeFeriado(id);
		return showFeriados();
		
	}
	
	
	@GetMapping(value = "/listar/{ano}")
	public String showFeriadoList(Model model, @PathVariable("ano") int ano) {
	    model.addAttribute("feriados", feriadoService.findFeriadosByYear(ano));
	    return "feriadotable :: resultsList";
	}
	
	@GetMapping("/feriadoform")
	private String redirectFeriadoForm(@RequestParam(name="id",required=false) int id,Model model) {
		FeriadoModel feriado = new FeriadoModel();
		if(id!=0) {
			feriado = feriadoService.findFeriadosByIdModel(id);
		}

		model.addAttribute("feriadoModel",feriado);
		return "feriadomodal :: modalf";
	}
	
	@GetMapping("/feriadoform2")
	private String FeriadoForm(@RequestParam(name="id",required=false) int id,Model model) {
		FeriadoModel feriado = new FeriadoModel();
		if(id!=0) {
			feriado = feriadoService.findFeriadosByIdModel(id);
		}

		model.addAttribute("feriadoModel",feriado);
		return "feriadomodal :: modalf";
	}
	
	
	@PostMapping("/addferiado")
	public String addContact(@ModelAttribute(name="feriadoModel") FeriadoModel feriadoModel,Model model) {
		LOG.info("METHOD: addferiado() --PARMS:" +feriadoModel.toString());
		if(null != feriadoService.addFeriado(feriadoModel)) {
			model.addAttribute("result",1);
		}else{
			model.addAttribute("result",0);
		}
		
	
		return ViewConstant.FERIADOS;
		
	}
	
	
}
