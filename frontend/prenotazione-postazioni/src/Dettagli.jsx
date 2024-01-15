import React from 'react';
import './Dettagli.css';

export const DettagliPreno = () => {
    const dettagli = {
        id: 1,
        ufficio: 'Bari',
        stanza: 'Stanza Piccola',
        postazione: 'P1',
        utente: 'Andres Carrillo',
    };
    const dettagli1 = {
        CreataDa: 'Giorgio Minerba',
        DataPrenotazione: '18/01/2024',
        DataCreazione: '12/01/2024',
        ModificataDa: '',
        DataModificazione: ''
    };

    return (
        <div className="Dettagli-prenotazione">
            <h2 className='card-title text-info font-weight-bold text-left my-3'>Dettagli prenotazione</h2>
            <div className='Dettagli-columns'>
                <div className='Dettagli-column'>
                    <p className='Dettagli-label'><span className='text-info'>Id:</span> {dettagli.id}</p>
                    <p className='Dettagli-label'><span className='text-info'>Ufficio:</span> {dettagli.ufficio}</p>
                    <p className='Dettagli-label'><span className='text-info'>Stanza:</span> {dettagli.stanza}</p>
                    <p className='Dettagli-label'><span className='text-info'>Postazione:</span> {dettagli.postazione}</p>
                    <p className='Dettagli-label'><span className='text-info'>Utente:</span> {dettagli.utente}</p>
                </div>
                <div className='Dettagli-column'>
                    <p className='Dettagli-label'><span className='text-info'>Creato da:</span> {dettagli1.CreataDa}</p>
                    <p className='Dettagli-label'><span className='text-info'>Data di prenotazione:</span> {dettagli1.DataPrenotazione}</p>
                    <p className='Dettagli-label'><span className='text-info'>Data di Creazione:</span> {dettagli1.DataCreazione}</p>
                    <p className='Dettagli-label'><span className='text-info'>Modificato da:</span> {dettagli1.ModificataDa}</p>
                    <p className='Dettagli-label'><span className='text-info'>Data di Modifica :</span> {dettagli1.DataModificazione}</p>
                </div>
            </div>
        </div >
    );
};

export default DettagliPreno;
