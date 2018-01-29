package com.inabif.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inabif.component.FeriadoConverter;
import com.inabif.entity.Feriado;
import com.inabif.model.FeriadoModel;
import com.inabif.repository.FeriadoRepository;
import com.inabif.service.FeriadoService;


@Service("feriadoServiceImpl")
public class FeriadoServiceImpl implements FeriadoService{

	@Autowired
	@Qualifier("feriadoRepository")
	private FeriadoRepository feriadoRepository;
	
	@Autowired
	@Qualifier("feriadoConverter")
	private FeriadoConverter feriadoConverter;
	
	@Override
	public FeriadoModel addFeriado(FeriadoModel feriadoModel) {
		Feriado feriado=feriadoRepository.save(feriadoConverter.convertFeriadoModel2Feriado(feriadoModel));
		
		return feriadoConverter.convertFeriado2FeriadoModel(feriado);
	}

	@Override
	public List<FeriadoModel> listAllFeriados() {
		List<Feriado> feriados = feriadoRepository.findAll();
		List<FeriadoModel> feriadosModel= new ArrayList<FeriadoModel>();
		for(Feriado feriado : feriados) {
			feriadosModel.add(feriadoConverter.convertFeriado2FeriadoModel(feriado));
		}
		
	
		return feriadosModel;
	}

	@Override
	public List<FeriadoModel> findFeriadosByYear(int ano) {
		
		List<Feriado> feriados = feriadoRepository.findFeriadosByYear(ano);
		List<FeriadoModel> feriadosModel= new ArrayList<FeriadoModel>();
		for(Feriado feriado : feriados) {
			feriadosModel.add(feriadoConverter.convertFeriado2FeriadoModel(feriado));
		}
		
	
		return feriadosModel;
	}

	@Override
	public FeriadoModel findFeriadosByIdModel(int id) {
		Feriado feriado = feriadoRepository.findByIdferiado(id);
		//FeriadoModel feriadosModel = new FeriadoModel();
		FeriadoModel feriadosModel = feriadoConverter. convertFeriado2FeriadoModel(feriado);
		return feriadosModel;
	}

	@Override
	public void removeFeriado(int id) {
		feriadoRepository.delete((feriadoRepository.findByIdferiado(id)));
		
	}
	
	

}
