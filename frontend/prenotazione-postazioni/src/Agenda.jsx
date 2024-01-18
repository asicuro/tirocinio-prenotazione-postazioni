import React from 'react';
import "./Agenda.css";

export const Agenda = ({ giorno, setGiorno, prenotazioni }) => {

    const carta = (
        <div className="card btn carta pl-0" >
            <div className="card-body d-flex">
                <div className='col-md-8'>
                    <p className="card-title font-weight-bold h5 text-left" style={{ color: "#3AA4B3" }}>Academy-A2</p>
                    <p className="card-text mb-2 text-muted">Effettuato da Daniel Zotti</p>
                </div>
                <div className='col-md-4'>
                    <button type="button" className="btn btn-sm me-1 btn-info" onClick={() => alert(" modificato")}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#729da3" class="bi bi-pencil-fill" viewBox="0 0 16 16">
                            <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.5.5 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11z" />
                        </svg>
                    </button>
                    <button type="button" className="btn btn-info btn-sm" onClick={() => alert("eliminato")}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#729da3" class="bi bi-calendar2-x-fill" viewBox="0 0 16 16">
                            <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5m9.954 3H2.545c-.3 0-.545.224-.545.5v1c0 .276.244.5.545.5h10.91c.3 0 .545-.224.545-.5v-1c0-.276-.244-.5-.546-.5m-6.6 5.146a.5.5 0 1 0-.708.708L7.293 10l-1.147 1.146a.5.5 0 0 0 .708.708L8 10.707l1.146 1.147a.5.5 0 0 0 .708-.708L8.707 10l1.147-1.146a.5.5 0 0 0-.708-.708L8 9.293z" />
                        </svg>

                    </button>
                </div>
            </div>
        </div >
    );

    const premuto = () => {
        const nuovaData = new Date();
        setGiorno(nuovaData);
        console.log({ giorno });
    };

    return (
        <div className="menu">
            <div className="titolocontainer">
                <button
                    className="tiny-btn btn btn-primary"
                    onClick={() => premuto()}
                >
                    Oggi
                </button>
                <h4 className="titolo">
                    {new Date(giorno).toLocaleDateString()}
                </h4>
            </div>
            <div className="overflow-y-auto verocard">
                <div>{prenotazioni.map((prenotazione) => [carta])}</div>
            </div>
        </div>
    );
};
