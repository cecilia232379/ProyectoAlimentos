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
@RequestMapping("/principal")
public class PrincipalController {
	


	private static final Log LOG = LogFactory.getLog(PrincipalController.class);
	
	
	protected HttpServletRequest request;
	
	public void execute() {
		
	}
	
	
	@GetMapping("/")
	public String inicio(Model model) {
			//HttpSession s       = request.getSession();
	        //String parametro    = request.getParameter("pAccion");
	        //String Sistema      = String.valueOf(request.getParameter("CodS"));
	        //String Modulo       = String.valueOf(request.getParameter("CodM"));
	        //String Usuario      = String.valueOf(request.getParameter("CodU"));
	        //String Persona      = String.valueOf(request.getParameter("CodP"));
			String Sistema = "21";
			String Modulo ="22";
			String Usuario="103";
			String Persona="31867";
			String Perfil="84";
			//--
	        //System.out.println("parametro"+parametro);
			
			
			
	        System.out.println("Sistema"+Sistema);
	        System.out.println("Modulo"+Modulo);
	        System.out.println("Usuario"+Usuario);
	        System.out.println("Persona"+Persona);
	       
	        
	        
	        model.addAttribute("active", "escritorio");
		return "inicio";
		
	}
	
	
	
	
}
