package com.mitocode.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.dao.TablaDAO;
import com.mitocode.dao.impl.TablaDAOImpl;
import com.mitocode.model.Celda;
import com.mitocode.model.Columna;
import com.mitocode.model.Fila;
import com.mitocode.service.ITablaService;

public class TablaServiceImpl implements ITablaService {

	private TablaDAO dao;

	public TablaServiceImpl() {
		dao = new TablaDAOImpl();
	}

	@Override
	public List<Fila> getFilas() throws Exception {
		List<Fila> filas = new ArrayList<>();
		try {
			filas = dao.getFilas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Columna> getColumnas() throws Exception {
		List<Columna> columnas = new ArrayList<>();
		try {
			columnas = dao.getColumnas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnas;
	}

	@Override
	public List<Celda> getCeldas() throws Exception {
		List<Celda> celdas = new ArrayList<>();
		try {
			celdas = dao.getCeldas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return celdas;
	}

	@Override
	public void actualizarFila(Fila fila) throws Exception {
		try {
			dao.actualizarFila(fila);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
