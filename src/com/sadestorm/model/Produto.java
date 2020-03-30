package com.sadestorm.model;

public class Produto {

	String marca;
	String modelo;
	String cor;
	String tipoProduto;
	String codProduto;
	float valor;

	public Produto(String marca, String modelo, String cor, String tipoProduto, String codProduto,
			String disponibilidade, String quantidade, float valor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.tipoProduto = tipoProduto;
		this.codProduto = codProduto;
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
