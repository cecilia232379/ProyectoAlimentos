package com.inabif.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inabif.entity.Feriado;


@Repository("feriadoRepository")
public interface FeriadoRepository extends JpaRepository<Feriado,Serializable>{

	
	@Query(value="select * from Tgferiado t where EXTRACT (YEAR FROM t.ferfechaferiado) = :ano", 
	        nativeQuery=true)
	List<Feriado> findFeriadosByYear(@Param("ano") int ano);
	
	
	public abstract Feriado findByIdferiado(int id);
	
	public abstract Feriado findByFerfechaferiado(Date fechaferiado);
	
}
