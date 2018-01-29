package com.inabif.controller;

import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.inabif.component.PageWrapper;
import com.inabif.constant.ViewConstant;
import com.inabif.entity.Periodo;
import com.inabif.model.FeriadoModel;
import com.inabif.model.PeriodoModel;
//import com.inabif.constant.ViewConstant;
import com.inabif.service.PeriodoService;





@Controller
@RequestMapping("/periodo")
public class PeriodoController {
	


	private static final Log LOG = LogFactory.getLog(PeriodoController.class);
	@Autowired
	@Qualifier("periodoServiceImpl")
	private PeriodoService periodoService;
	
	protected HttpServletRequest request;
	
	public void execute() {
		
	}
	
	
	@GetMapping("/listar")
	public ModelAndView showPeriodos() {
		ModelAndView mav = new ModelAndView(ViewConstant.PERIODOS);
		//mav.addObject("feriados",feriadoService.findFeriadosByYear(2017));
		//LOG.info("METHOD: showFeriados() --PARMS:" +feriadoService.findFeriadosByYear(2017));
		//mav.addObject("sistema",ViewConstant.SISTEMA_TITULO);
	
		//LOG.info("sesion"+sesion.getAttribute("usuarioSession"));
		return mav;
		
	}
	
	@GetMapping("/cancel")
	private String cancel() {
		//model.addAttribute("contactModel",new ContactModel());
		return ViewConstant.PERIODOS;
	}
	
	@GetMapping("/removeperiodo")
	public ModelAndView removePeriodo(@RequestParam(name="id",required=true) int id) {
		periodoService.removePeriodo(id);
		return showPeriodos();
		
	}
	
	
	@GetMapping(value = "/listar/{ano}")
	public String showPeriodoList(Model model, @PathVariable("ano") int ano) {
	    model.addAttribute("periodos", periodoService.findPeriodosByYear(ano));
	    return "periodotable :: resultsList";
	}
	
	@GetMapping(value = "/listar/{ano}/{mes}")
	public String showPeriodoList(Model model, @PathVariable("ano") int ano, @PathVariable("mes") int mes) {
	    model.addAttribute("periodos", periodoService.findPeriodosByYearAndMonth(ano,mes));
	    return "periodotable :: resultsList";
	}
	
	@GetMapping("/periodoform")
	private String redirectPeriodoForm(@RequestParam(name="id",required=false) int id,Model model) {
		PeriodoModel periodo = new PeriodoModel();
		if(id!=0) {
			periodo = periodoService.findPeriodosByIdModel(id);
		}

		model.addAttribute("periodoModel",periodo);
		return ViewConstant.PERIODO_FORM;
	}
	
	@PostMapping("/addperiodo")
	public String addContact(@ModelAttribute(name="periodoModel") PeriodoModel periodoModel,Model model) {
		LOG.info("METHOD: addferiado() --PARMS:" +periodoModel.toString());
		if(null != periodoService.addPeriodo(periodoModel)) {
			model.addAttribute("result",1);
		}else{
			model.addAttribute("result",0);
		}
		
	
		return ViewConstant.PERIODOS;
		
	}
	
	
}
