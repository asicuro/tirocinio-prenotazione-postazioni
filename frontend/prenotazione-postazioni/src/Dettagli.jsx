import React from 'react';
import './Dettagli.css';

export const DettagliPreno = () => {
    const dettagli = {
        id: 1,
        office: 'Bari',
        room: 'Stanza Piccola',
        position: 'P1',
        user: 'Andres Carrillo',
    };
    const dettagli1 = {
        createdBy: 'Giorgio Minerba',
        bookingDate: '18/01/2024',
        creationDate: '12/01/2024',
        modifiedBy: '',
        modificationDate: ''
    };

    return (
        <div className="Dettagli-prenotazione">
            <h2 className='card-title text-info font-weight-bold text-left'>Dettagli prenotazione</h2>
            <div className='Dettagli-columns'>
                <div className='Dettagli-column'>
                    {Object.entries(dettagli).map(([key, value]) => (
                        <div key={key} className='Dettagli-row'>
                            <div className="Dettagli-label">{key}:</div>
                            <div className="Dettagli-value">{value}</div>
                        </div>
                    ))}
                </div>
                <div className='Dettagli-column'>
                    {Object.entries(dettagli1).map(([key1, value1]) => (
                        <div key={key1} className='Dettagli-row2'>
                            <div className="Dettagli-label2">{key1}:</div>
                            <div className="Dettagli-value2">{value1}</div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default DettagliPreno;
