import React from 'react';
import './Dettagli.css';

export const DettagliPreno = ({ giorno, setGiorno }) => {

    const dettagli = {
        id: 1,
        ufficio: 'Bari',
        stanza: 'Stanza Piccola',
        postazione: 'P1',
        utente: 'Andres Carrillo',
    };
    const dettagli1 = {
        CreataDa: 'Giorgio Minerba',
        DataPrenotazione: '',
        DataCreazione: '12/01/2024',
        ModificataDa: '',
        DataModificazione: ''
    };


    return (
        <div className="Dettagli-prenotazione">
            <h2 className='card-title text-info font-weight-bold text-left my-3'><span className='Title'>Dettagli prenotazione</span></h2>
            <div className='Dettagli-columns'>
                <div className='Dettagli-column'>
                    <p className='Dettagli-label'><span className='colore'>Id:</span> {dettagli.id}</p>
                    <p className='Dettagli-label'><span className='colore'>Ufficio:</span> {dettagli.ufficio}</p>
                    <p className='Dettagli-label'><span className='colore'>Stanza:</span> {dettagli.stanza}</p>
                    <p className='Dettagli-label'><span className='colore'>Postazione:</span> {dettagli.postazione}</p>
                    <p className='Dettagli-label'><span className='colore'>Utente:</span> {dettagli.utente}</p>
                </div>
                <div className='Dettagli-column'>
                    <p className='Dettagli-label'><span className='colore'>Creato da:</span> {dettagli1.CreataDa}</p>
                    <p className='Dettagli-label'><span className='colore'>Data di prenotazione:</span>{giorno.toLocaleDateString()}</p>
                    <p className='Dettagli-label'><span className='colore'>Data di Creazione:</span> {dettagli1.DataCreazione}</p>
                    <p className='Dettagli-label'><span className='colore'>Modificato da:</span> {dettagli1.ModificataDa}</p>
                    <p className='Dettagli-label'><span className='colore'>Data di Modifica :</span> {dettagli1.DataModificazione}</p>
                </div>
            </div>
        </div >
    );
};

export default DettagliPreno;
