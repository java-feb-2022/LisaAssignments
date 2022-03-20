package com.lisa.NinjasAndDojosSolutions.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.NinjasAndDojosSolutions.models.Dojo;
import com.lisa.NinjasAndDojosSolutions.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
	List<Ninja> findAllByDojo(Dojo dojo);
}