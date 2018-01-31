package com.inabif.controller;

import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Temporal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inabif.constant.ViewConstant;
import com.inabif.entity.Periodo;
import com.inabif.model.AlimentoModel;
import com.inabif.model.FeriadoModel;
import com.inabif.service.AlimentoService;
//import com.inabif.constant.ViewConstant;
import com.inabif.service.FeriadoService;
import com.inabif.service.PeriodoService;





@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	@Qualifier("alimentoServiceImpl")
	private AlimentoService alimentoService;
	
	@Autowired
	@Qualifier("periodoServiceImpl")
	private PeriodoService periodoService;


	private static final Log LOG = LogFactory.getLog(RegistroController.class);
	
	
	protected HttpServletRequest request;
	
	
	
	@GetMapping("/")
	public String index(final ModelMap model) {
		//ModelAndView mav = new ModelAndView(ViewConstant.REGISTRO);
		//ModelMap model;
		TimeZone zone = TimeZone.getTimeZone("America/Lima");
		
		Date d1 = new Date();
		System.out.println("date"+d1);
	    Calendar cl = Calendar. getInstance(zone);
	    cl.setTime(d1);
	    
	    LocalDate date = LocalDate.now();
	    TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
	    DayOfWeek dow = date.getDayOfWeek();
	    int weekNumber = date.get(woy);
	    int weekDay = dow.getValue();
	    int ano = date.getYear();
	    
	    
	    
	    
	    //int dia_semana = cl.DAY_OF_WEEK;
	    System.out.println("semana_ano"+weekNumber);
	    System.out.println("dia_semana"+weekDay);
	    if (weekDay == 1 || weekDay == 2 || weekDay == 3  || weekDay == 4 || weekDay == 5) {
	    	weekNumber = weekNumber - 1; 
			 
		 }
	    System.out.println("semana_ano"+weekNumber);
	    System.out.println("ano"+ano);
	    //hay algo
	    System.out.println("periododSeriv"+periodoService.findOneByPersemanaAndPeryeart(weekNumber, ano));	
	    if(null != periodoService.findOneByPersemanaAndPeryeart(weekNumber, ano)) {
	    	Periodo periodo= periodoService.findOneByPersemanaAndPeryeart(weekNumber, ano);
	    	model.addAttribute("periodo",periodo.getIdperiodo() );
	    	model.addAttribute("semana", periodo.getPersemana());
	    	model.addAttribute("idcentro", 1);
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String formattedDate_fecinicio = formatter.format(periodo.getPerfecinicio());
	        String formattedDate_fecfin = formatter.format(periodo.getPerfecfin());
	    	
	    	String semanaTexto = "Semana del "+formattedDate_fecinicio+" al "+formattedDate_fecfin;
	    	model.addAttribute("semanaTexto",semanaTexto);
	    	model.addAttribute("cedifNombre","CEDIF PESTALOZZI");
	    	return ViewConstant.REGISTRO;
	    }else {
	    	
	    	return ViewConstant.PONGANSE_CONTACTO_REGISTRO;
	    }
		
	}
	
	@PostMapping(value = "saveAlimentos")
	public @ResponseBody String goUpdatePOST(@RequestBody AlimentoModel[] list) {
		
	    for(AlimentoModel i : list) {
	    	alimentoService.addAlimento(i);
	        System.out.println(i.getAlidia());
	    }
	    return "alimentoexito";

	} 
	
	
	@GetMapping("/cancel")
	private String cancel() {
		//model.addAttribute("contactModel",new ContactModel());
		return ViewConstant.FERIADOS;
	}
	
		
	
	
	
	
}
