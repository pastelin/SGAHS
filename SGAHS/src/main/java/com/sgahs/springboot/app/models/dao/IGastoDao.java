package com.sgahs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sgahs.springboot.app.models.entity.Gasto;

public interface IGastoDao extends CrudRepository<Gasto, Long> {

}
