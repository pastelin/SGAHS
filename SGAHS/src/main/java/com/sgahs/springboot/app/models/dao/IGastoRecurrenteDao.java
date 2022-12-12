package com.sgahs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sgahs.springboot.app.models.entity.GastoRecurrente;

public interface IGastoRecurrenteDao extends CrudRepository<GastoRecurrente, Integer> {

}
