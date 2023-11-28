package it.linksmt.prenotazione.postazioni.core.filters;

import java.util.Date;

public class PrenotazioneFilter {

  private Long postazioneId;
  private Long stanzaId;
  private Date inizioPeriodo;
  private Date finePeriodo;

  public Long getPostazioneId() {
    return postazioneId;
  }

  public Long getStanzaId() {
    return stanzaId;
  }

  public Date getInizioPeriodo() {
    return inizioPeriodo;
  }

  public Date getFinePeriodo() {
    return finePeriodo;
  }
}
