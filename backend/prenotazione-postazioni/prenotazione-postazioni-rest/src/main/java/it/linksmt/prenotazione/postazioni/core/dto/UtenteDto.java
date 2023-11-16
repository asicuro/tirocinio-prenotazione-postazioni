package it.linksmt.prenotazione.postazioni.core.dto;

public class UtenteDto {

	private Long id;
	
	private String username;
	
	private String password;
	
	private String ruolo;
	
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
		
}
