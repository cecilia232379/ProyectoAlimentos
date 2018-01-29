package com.inabif.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inabif.model.FeriadoModel;
import com.inabif.service.FeriadoService;




@RestController
@RequestMapping("/feriadorest")
public class FeriadoRestController {
	
	@Autowired
	@Qualifier("feriadoServiceImpl")
	private FeriadoService feriadoService;
	
	
	@GetMapping(value = "/getferiadobyano/{ano}")
	public List<FeriadoModel> postCustomer(@PathVariable int ano) {
		System.out.println("ano"+ano);	
		return feriadoService.findFeriadosByYear(ano);
	}

}
