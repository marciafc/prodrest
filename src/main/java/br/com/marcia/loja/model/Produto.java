package br.com.marcia.loja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long produtoId;
	
	private String nomenclatura;
	
	private String sal;
	
	private String codigo;
	
	private String ean;
	
	private String ncm;
	
	private Integer caixaPadrao;
	
	private Boolean ativo;
	
	private Float preco;
	

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public String getSal() {
		return sal;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getEan() {
		return ean;
	}

	public String getNcm() {
		return ncm;
	}

	public Integer getCaixaPadrao() {
		return caixaPadrao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public void setCaixaPadrao(Integer caixaPadrao) {
		this.caixaPadrao = caixaPadrao;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
