import React from 'react';
import "./Agenda.css";

export const Agenda = ({ giorno, setGiorno }) => {

    const carta = (
        <div className="card carta pl-0 text-left">
            <div className="card-body d-flex align-items-center">
                <div style={{ display: 'inline-block' }}>
                    <p className="card-title text-info font-weight-bold h6 text-left">Bari-Academy-A2</p>
                    <p className="card-text mb-2 text-muted">Effettuato da Daniel Zotti</p>
                </div>
                <div style={{ display: 'inline-block' }} className='ml-30'>
                    <button className='btn btn-default bottoni'>
                        <img src={process.env.PUBLIC_URL + '/edit.png'} alt="Edit" width="25" height="25" onClick={() => alert("modificato")} />
                    </button>
                    <button className='btn btn-default'>
                        <img src={process.env.PUBLIC_URL + '/delete.png'} alt="Delete" width="25" height="25" onClick={() => alert("eliminato")} />
                    </button>
                </div>
            </div>
        </div>
    );





    const premuto = () => {
        const nuovaData = new Date();
        setGiorno(nuovaData);
        console.log({ giorno });
    };

    return (
        <div className='menu'>
            <div className="titolocontainer">
                <button className="tiny-btn btn btn-primary" onClick={() => premuto()}>Oggi</button>
                <h4 className='titolo'>{giorno.toLocaleDateString()}</h4>
            </div>
            <div className="cardconteiner">
                {carta}
            </div>
        </div>
    );
};
