package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Celda;
import com.mitocode.model.Columna;
import com.mitocode.model.Fila;

public interface TablaDAO {

	List<Fila> getFilas() throws Exception;

	List<Columna> getColumnas() throws Exception;

	List<Celda> getCeldas() throws Exception;
	
	void actualizarFila(Fila fila) throws Exception;
}
