package com.brasileirao.android.listview;

public class JogoItem {
	private int id;
	private String sigla_host, picurl_host, placar_host;

	public JogoItem() {
	}

	public JogoItem(int id, String sigla_host, String picurl_host, String placar_host) {
		super();
		this.id = id;
		this.sigla_host = sigla_host;
		this.picurl_host = picurl_host;
		this.placar_host = placar_host;		
	}
/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
	public String getSigla_host() {
		return sigla_host;
	}

	public void setSigla_host(String sigla_host) {
		this.sigla_host = sigla_host;
	}

	public String getPicurl_host() {
		return picurl_host;
	}

	public void setPicurl_host(String picurl_host) {
		this.picurl_host = picurl_host;
	}

	public String getPlacar_host() {
		return placar_host;
	}

	public void setPlacar_host(String placar_host) {
		this.placar_host = placar_host;
	}

		
}