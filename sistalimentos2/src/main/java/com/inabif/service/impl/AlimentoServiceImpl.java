package com.inabif.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inabif.component.AlimentoConverter;
import com.inabif.component.FeriadoConverter;
import com.inabif.entity.Alimento;
import com.inabif.entity.Feriado;
import com.inabif.model.AlimentoModel;
import com.inabif.model.FeriadoModel;
import com.inabif.repository.AlimentoRepository;
import com.inabif.repository.FeriadoRepository;
import com.inabif.service.AlimentoService;


@Service("alimentoServiceImpl")
public class AlimentoServiceImpl implements AlimentoService{
	
	@Autowired
	@Qualifier("alimentoRepository")
	private AlimentoRepository alimentoRepository;
	
	@Autowired
	@Qualifier("alimentoConverter")
	private AlimentoConverter alimentoConverter;

	@Override
	public AlimentoModel addAlimento(AlimentoModel alimentoModel) {
		Alimento alimento=alimentoRepository.save(alimentoConverter.convertAlimentoModel2Alimento(alimentoModel));
		
		return alimentoConverter.convertAlimento2AlimentoModel(alimento);
	}

//	@Autowired
//	@Qualifier("alimentoRepository")
//	private AlimentoRepository alimentoRepository;

//	@Override
//	public List<Object> reporteMesCedifAlimentos(int ano, int mes, int periodo) {
//		Map<String, String> results = new HashMap<String, String>();
//
////		   EntityManager em = entityManagerFactor.createEntityManager();
////		   
////		   Query q = em.createNativeQuery("SELECT DISTINCT location.mftcc, location.name FROM Location location");
////		   // Construct and run query
////		   String jpaQuery = 
////		   List<Object[]> resultList = em.createQuery(jpaQuery).getResultList();
////
////		   return resultList;
//		
//	}
	
	
	

}
