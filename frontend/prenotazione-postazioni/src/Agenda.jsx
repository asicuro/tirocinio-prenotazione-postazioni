import React from 'react';
import "./Agenda.css";
import axios from 'axios';
import { useEffect, useState } from "react";

export const Agenda = ({ giorno, setGiorno, prenotazioni, setPrenotazione }) => {


    const [prenotazioniAggiornate, setprenotazioniAggiornate] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const updatedData = await Promise.all(
                prenotazioni.map(async (prenotazione) => {
                    try {
                        const utenti = await axios.get(`http://localhost:9890/user/${prenotazione.utenteId}`);
                        const utentiData = utenti.data;
                        const utentiAdm = await axios.get(`http://localhost:9890/user/${prenotazione.createUserId}`);
                        const utenteAdmData = utentiAdm.data;
                        let utenteAdmModData;
                        if (prenotazione.editUserId == null) {
                            utenteAdmModData = 0;
                        } else {
                            const utentiAdmMod = await axios.get(`http://localhost:9890/user/${prenotazione.editUserId}`);
                            utenteAdmModData = utentiAdmMod.data;
                        }
                        const postazione = await axios.get(`http://localhost:9890/postazione/${prenotazione.postazioneId}`)
                        const postazioneData = postazione.data;
                        const stanza = await axios.get(`http://localhost:9890/stanza/${postazioneData.stanzaId}`)
                        const stanzaData = stanza.data;
                        const ufficio = await axios.get(`http://localhost:9890/ufficio/${stanzaData.ufficioId}`)
                        const ufficioData = ufficio.data;
                        return {
                            ...prenotazione,
                            username: utentiData.username,
                            utenteAdmin: utenteAdmData.username,
                            utenteAdminMod: utenteAdmModData.username,
                            ...postazione,
                            stanzaId: postazioneData.stanzaId,
                            ...stanza,
                            nome: stanzaData.nome,
                            ufficioId: stanzaData.ufficioId,
                            ...ufficio,
                            nomeuf: ufficioData.nomeUfficio,
                        };
                    } catch (err) {
                        console.log(err);
                        return prenotazione;
                    }
                })
            );
            setprenotazioniAggiornate(updatedData);
        };

        fetchData();
    }, [prenotazioni]);


    const premuto = () => {
        const nuovaData = new Date();
        setGiorno(nuovaData);
    };

    return (
        <div className='menu'>
            <div className='titolocontainer containter d-flex flex-wrap"'>
                <button className="tiny-btn btn btn-primary col-md-2" onClick={() => premuto()}>Oggi</button>
                <span className='titolo col-md-7 text-center'>{new Date(giorno).toLocaleDateString()}</span>
                <button className="tiny-btn btn btn-primary col-2" onClick={() => alert("aggiungi")}>+</button>
            </div>
            <div className='overflow-y-auto verocard'>
                <div>
                    {prenotazioniAggiornate.map((card, index) => (
                        <div className="card btn carta pl-0" key={index} onClick={() => setPrenotazione({
                            id: card.id,
                            ufficio: card.nomeuf,
                            stanza: card.nome,
                            createUser: card.utenteAdmin,
                            createDate: card.createDate,
                            editUser: card.utenteAdminMod,
                            utente: card.username,
                            postazione: card.postazioneId,
                            editDate: card.editDate,
                            dataPrenotazione: card.dataPrenotazione,
                        })}>
                            <div className="card-body d-flex">
                                <div>
                                    <span className='text-start text-muted pe-3 fs-5'>{index + 1} </span>
                                </div>
                                <div className='col-md-8'>
                                    <p className="card-title font-weight-bold h5 text-left" style={{ color: "#3AA4B3" }}>{card.nomeuf}-{card.nome}-{card.postazioneId}</p>
                                    <p className="card-text mb-2 text-muted">Per {card.username}</p>
                                </div>
                                <div className='col-md-4'>
                                    <button type="button" className="btn btn-sm me-1 btn-info" onClick={() => alert(" modificato")}>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#729da3" className="bi bi-pencil-fill" viewBox="0 0 16 16">
                                            <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" />
                                        </svg>
                                    </button>
                                    <button type="button" className="btn btn-info btn-sm" onClick={() => alert("eliminato")}>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#729da3" className="bi bi-calendar2-x-fill" viewBox="0 0 16 16">
                                            <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5m9.954 3H2.545c-.3 0-.545.224-.545.5v1c0 .276.244.5.545.5h10.91c.3 0 .545-.224.545-.5v-1c0-.276-.244-.5-.546-.5m-6.6 5.146a.5.5 0 1 0-.708.708L7.293 10l-1.147 1.146a.5.5 0 0 0 .708.708L8 10.707l1.146 1.147a.5.5 0 0 0 .708-.708L8.707 10l1.147-1.146a.5.5 0 0 0-.708-.708L8 9.293z" />
                                        </svg>

                                    </button>
                                </div>
                            </div>
                        </div >))}
                </div>
            </div>
        </div >
    );
};
