package com.sgahs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sgahs.springboot.app.models.entity.Ahorro;

public interface IAhorroDao extends CrudRepository<Ahorro, Long>{

}
