package com.inabif.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inabif.entity.Alimento;


@Repository("AlimentoRepository")
public interface AlimentoRepository extends JpaRepository<Alimento,Serializable>{

	
	
	
}
