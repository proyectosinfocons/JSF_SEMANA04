package com.mitocode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mitocode.model.Celda;
import com.mitocode.model.Columna;
import com.mitocode.model.Fila;
import com.mitocode.service.ITablaService;
import com.mitocode.service.impl.TablaServiceImpl;

@ManagedBean
@ViewScoped
public class IndexBean implements Serializable {

	private List<Fila> lstFilas;
	private List<Columna> lstColumnasNivel1;
	private List<Columna> lstColumnasNivel2;
	private List<Columna> lstColumnasNivel3;
	private List<Celda> lstCeldas;
	private ITablaService service;

	@PostConstruct
	public void init() {
		lstFilas = new ArrayList<>();
		lstColumnasNivel1 = new ArrayList<>();
		lstColumnasNivel2 = new ArrayList<>();
		lstColumnasNivel3 = new ArrayList<>();
		lstCeldas = new ArrayList<>();
		service = new TablaServiceImpl();
		this.listarFilas();
		this.listarColumnas();
		this.listarCeldas();
	}

	public void listarFilas() {
		try {
			lstFilas = service.getFilas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarColumnas() {
		List<Columna> lista;
		try {
			lista = service.getColumnas();
			for (Columna c : lista) {
				if (c.getNivel() == 1) {
					lstColumnasNivel1.add(c);
				}
				if (c.getNivel() == 2) {
					lstColumnasNivel2.add(c);
				}
				if (c.getNivel() == 3) {
					lstColumnasNivel3.add(c);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarCeldas() {
		try {
			lstCeldas = service.getCeldas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * getters & setters
	 */

	public List<Fila> getLstFilas() {
		return lstFilas;
	}

	public void setLstFilas(List<Fila> lstFilas) {
		this.lstFilas = lstFilas;
	}

	public List<Columna> getLstColumnasNivel1() {
		return lstColumnasNivel1;
	}

	public void setLstColumnasNivel1(List<Columna> lstColumnasNivel1) {
		this.lstColumnasNivel1 = lstColumnasNivel1;
	}

	public List<Columna> getLstColumnasNivel2() {
		return lstColumnasNivel2;
	}

	public void setLstColumnasNivel2(List<Columna> lstColumnasNivel2) {
		this.lstColumnasNivel2 = lstColumnasNivel2;
	}

	public List<Columna> getLstColumnasNivel3() {
		return lstColumnasNivel3;
	}

	public void setLstColumnasNivel3(List<Columna> lstColumnasNivel3) {
		this.lstColumnasNivel3 = lstColumnasNivel3;
	}

	public List<Celda> getLstCeldas() {
		return lstCeldas;
	}

	public void setLstCeldas(List<Celda> lstCeldas) {
		this.lstCeldas = lstCeldas;
	}

}
