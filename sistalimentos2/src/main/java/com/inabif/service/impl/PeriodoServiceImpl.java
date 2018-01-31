package com.inabif.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inabif.component.PeriodoConverter;
import com.inabif.entity.Periodo;
import com.inabif.model.PeriodoModel;
import com.inabif.repository.PeriodoRepository;
import com.inabif.service.PeriodoService;


@Service("periodoServiceImpl")
public class PeriodoServiceImpl implements PeriodoService{

	@Autowired
	@Qualifier("periodoRepository")
	private PeriodoRepository periodoRepository;
	
	@Autowired
	@Qualifier("periodoConverter")
	private PeriodoConverter periodoConverter;
	
	@Override
	public PeriodoModel addPeriodo(PeriodoModel periodoModel) {
		Periodo periodo=periodoRepository.save(periodoConverter.convertPeriodoModel2Periodo(periodoModel));
		
		return periodoConverter.convertPeriodo2PeriodoModel(periodo);
	}

	@Override
	public List<PeriodoModel> listAllPeriodos() {
		List<Periodo> periodos = periodoRepository.findAll();
		List<PeriodoModel> periodosModel= new ArrayList<PeriodoModel>();
		for(Periodo periodo : periodos) {
			periodosModel.add(periodoConverter.convertPeriodo2PeriodoModel(periodo));
		}
	
		return periodosModel;
	}

	@Override
	public List<PeriodoModel> findPeriodosByYear(int ano) {
		
		List<Periodo> periodos = periodoRepository.findByPeryeart(ano);
		List<PeriodoModel> periodosModel= new ArrayList<PeriodoModel>();
		for(Periodo periodo : periodos) {
			periodosModel.add(periodoConverter.convertPeriodo2PeriodoModel(periodo));
		}
		System.out.println("ano"+ano);
	
		return periodosModel;
	}

	@Override
	public PeriodoModel findPeriodosByIdModel(int id) {
		Periodo periodo = periodoRepository.findByIdperiodo(id);
		//FeriadoModel feriadosModel = new FeriadoModel();
		PeriodoModel periodosModel = periodoConverter. convertPeriodo2PeriodoModel(periodo);
		return periodosModel;
	}

	@Override
	public void removePeriodo(int id) {
		periodoRepository.delete((periodoRepository.findByIdperiodo(id)));
		
	}


	@Override
	public Page<Periodo> findPeriodosByYear(int year, Pageable pageable) {
		periodoRepository.findByPeryeart(year, pageable);
		return null;
	}

	@Override
	public List<PeriodoModel> findPeriodosByYearAndMonth(int ano, int mes) {
		List<Periodo> periodos = periodoRepository.findPeriodosByYearAndMonth(ano, mes);
		List<PeriodoModel> periodosModel= new ArrayList<PeriodoModel>();
		for(Periodo periodo : periodos) {
			periodosModel.add(periodoConverter.convertPeriodo2PeriodoModel(periodo));
		}
		System.out.println("ano"+ano);
		return periodosModel;
	}

	@Override
	public Periodo findOneByPersemanaAndPeryeart(int persemana, int peryeart) {
		return periodoRepository.findOneByPersemanaAndPeryeart(persemana,peryeart);
		//return pe;
	}
	
	

}
