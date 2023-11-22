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

	public UtenteDto setId(Long id) {
		this.id = id;
		return this;
	}

	public UtenteDto setUsername(String username) {
		this.username = username;
		return this;
	}

	public UtenteDto setPassword(String password) {
		this.password = password;
		return this;
	}

	public UtenteDto setRuolo(String ruolo) {
		this.ruolo = ruolo;
		return this;
	}

}
