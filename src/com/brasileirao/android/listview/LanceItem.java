package com.brasileirao.android.listview;

public class LanceItem {
	private int id;
	private String sigla_host, picurl_host, placar_host, placar_guest,
				picurl_guest, sigla_guest, estadio, status, dia, hora,
				minutes, extra_info, text1, text2;

	public LanceItem() {
	}

	public LanceItem(int id, String sigla_host, String picurl_host, String placar_host , String placar_guest, 
			String picurl_guest, String sigla_guest, String estadio, String status, String dia, String hora,
			String minutes,String extra_info,String text1, String text2) {
		super();
		this.id = id;
		this.sigla_host = sigla_host;
		this.picurl_host = picurl_host;
		this.placar_host = placar_host;
		this.placar_guest = placar_guest;
		this.picurl_guest = picurl_guest;
		this.sigla_guest = sigla_guest;
		this.estadio = estadio;
		this.dia = dia;
		this.hora = hora;
		
		this.minutes = minutes; 
		this.extra_info = extra_info; 
		this.text1 = text1;  
		this.text2 = text2;
		
	}

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

	public String getPlacar_guest() {
		return placar_guest;
	}

	public void setPlacar_guest(String placar_guest) {
		this.placar_guest = placar_guest;
	}

	public String getPicurl_guest() {
		return picurl_guest;
	}

	public void setPicurl_guest(String picurl_guest) {
		this.picurl_guest = picurl_guest;
	}

	public String getSigla_guest() {
		return sigla_guest;
	}

	public void setSigla_guest(String sigla_guest) {
		this.sigla_guest = sigla_guest;
	}
	
	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}	
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}		
	

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}		

	public String getExtra_info() {
		return extra_info;
	}

	public void setExtra_info(String extra_info) {
		this.extra_info = extra_info;
	}		
	
	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}
	
	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}		
	
	
}