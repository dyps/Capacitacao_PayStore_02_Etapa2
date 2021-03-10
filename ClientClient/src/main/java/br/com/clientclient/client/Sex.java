package br.com.clientclient.client;

public enum Sex {

	MASCULINO("Masculino"), FEMININO("Feminino");

	private String nome;

	Sex(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}