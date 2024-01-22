import React from "react";
import PropTypes from "prop-types";
import "./Dettagli.css";

export const DettagliPreno = ({ giorno, prenotazione }) => {


    return (
        <div className="Dettagli-prenotazione px-2">
            <h2 className="card-title text-info font-weight-bold text-left my-3">
                <span className="Title">Dettagli prenotazione</span>
            </h2>
            <div className="Dettagli-columns">
                <div className="Dettagli-column">
                    <p className="Dettagli-label">
                        <span className="colore">Id:</span> {prenotazione.id}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Ufficio:</span>{" "}
                        {prenotazione.ufficio}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Stanza:</span>{" "}
                        {prenotazione.stanza}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Postazione:</span>{" "}
                        {prenotazione.postazione}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Utente:</span>{" "}
                        {prenotazione.utente}
                    </p>
                </div>
                <div className="Dettagli-column">
                    <p className="Dettagli-label">
                        <span className="colore">Creato da:</span>{" "}
                        {prenotazione.createUser}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Data di prenotazione:</span>
                        {prenotazione.dataPrenotazione &&
                            new Date(
                                prenotazione.dataPrenotazione
                            ).toLocaleDateString()}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Data di Creazione:</span>{" "}
                        {prenotazione.createDate &&
                            new Date(
                                prenotazione.createDate
                            ).toLocaleDateString()}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Modificato da:</span>{" "}
                        {prenotazione.editUser}
                    </p>
                    <p className="Dettagli-label">
                        <span className="colore">Data di Modifica :</span>{" "}
                        {prenotazione.editDate}
                    </p>
                </div>
            </div>
        </div>
    );


};

DettagliPreno.propTypes = {
    giorno: PropTypes.instanceOf(Date).isRequired
};


export default DettagliPreno;
