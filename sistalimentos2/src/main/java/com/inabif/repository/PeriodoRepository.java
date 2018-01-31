package com.inabif.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inabif.entity.Feriado;
import com.inabif.entity.Periodo;


@Repository("periodoRepository")
public interface PeriodoRepository extends JpaRepository<Periodo,Serializable>{

	
	
	public abstract List<Periodo> findByPeryeart(int year);
	
	@Query(value="select * from tfperiodos t where EXTRACT (YEAR FROM t.perfecinicio) = :ano and EXTRACT (MONTH FROM t.perfecinicio) = :month", 
	        nativeQuery=true)
	List<Periodo> findPeriodosByYearAndMonth(@Param("ano") int ano,@Param("month") int month);
	
	public abstract Page<Periodo> findByPeryeart(int year,Pageable pageable);
	
	public abstract Periodo findByIdperiodo(int id);
	
	public abstract Periodo findOneByPersemanaAndPeryeart(int persemana, int peryeart);
	
}
