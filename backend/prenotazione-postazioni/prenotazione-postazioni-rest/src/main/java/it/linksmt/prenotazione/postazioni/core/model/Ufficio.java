package it.linksmt.prenotazione.postazioni.core.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ufficio")
public class Ufficio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "create_user_id")
    private Long createUserId;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "edit_user_id")
    private Long editUserId;
    @Column(name = "edit_date")
    private Date editDate;
    @Column(name = "indirizzo")
    private String Indirizzo;
    @Column(name = "nome_ufficio")
    private String nomeUfficio;
}
