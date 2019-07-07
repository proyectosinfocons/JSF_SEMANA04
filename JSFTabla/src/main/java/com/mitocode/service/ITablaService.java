package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Celda;
import com.mitocode.model.Columna;
import com.mitocode.model.Fila;

//ManagedBean ---> Service -> DAO Oracle
//ManagedBean ---> Service -> DAO Mysql
//ManagedBean ---> Service -> WS

public interface ITablaService {

	List<Fila> getFilas() throws Exception;

	List<Columna> getColumnas() throws Exception;

	List<Celda> getCeldas() throws Exception;
		
	void actualizarFila(Fila fila) throws Exception;
}
