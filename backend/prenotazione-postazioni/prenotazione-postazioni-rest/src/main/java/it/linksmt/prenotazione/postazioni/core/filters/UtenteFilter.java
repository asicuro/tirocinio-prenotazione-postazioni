package it.linksmt.prenotazione.postazioni.core.filters;

import java.util.Date;

public class UtenteFilter {

  private Date dataPrenotazione;
  private Date inizioPeriodo;
  private Date finePeriodo;
  private Long stanzaId;
  private Long postazioneId;
  private Long ufficioId;

  public Date getDataPrenotazione() {
    return dataPrenotazione;
  }

  public Date getInizioPeriodo() {
    return inizioPeriodo;
  }

  public Date getFinePeriodo() {
    return finePeriodo;
  }

  public Long getStanzaId() {
    return stanzaId;
  }

  public Long getPostazioneId() {
    return postazioneId;
  }

  public Long getUfficioId() {
    return ufficioId;
  }

}
