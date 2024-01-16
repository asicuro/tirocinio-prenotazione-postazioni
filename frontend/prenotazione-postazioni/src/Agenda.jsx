import React from 'react';
import "./Agenda.css";

export const Agenda = ({ giorno, setGiorno }) => {

    const carta = (
        <div className="card btn carta pl-0" >
            <div className="card-body d-flex">
                <div className='col-md-8'>
                    <p className="card-title font-weight-bold h5 text-left" style={{ color: "#3AA4B3" }}>Bari-Academy-A2</p>
                    <p className="card-text mb-2 text-muted">Effettuato da Daniel Zotti</p>
                </div>
                <div className='col-md-4'>
                    <button type="button" className="btn btn-sm me-1 btn-info" onClick={() => alert(" modificato")}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#96cfd7" class="bi bi-pencil-square" viewBox="0 0 16 16">
                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"></path>
                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"></path>
                        </svg>
                    </button>
                    <button type="button" className="btn btn-info btn-sm" onClick={() => alert("eliminato")}>
                        <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#96cfd7" class="bi bi-calendar2-x" viewBox="0 0 16 16">
                            <path d="M6.146 8.146a.5.5 0 0 1 .708 0L8 9.293l1.146-1.147a.5.5 0 1 1 .708.708L8.707 10l1.147 1.146a.5.5 0 0 1-.708.708L8 10.707l-1.146 1.147a.5.5 0 0 1-.708-.708L7.293 10 6.146 8.854a.5.5 0 0 1 0-.708"></path>
                            <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5M2 2a1 1 0 0 0-1 1v11a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1z"></path>
                            <path d="M2.5 4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H3a.5.5 0 0 1-.5-.5z"></path>
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
        <div className='menu'>
            <div className='titolocontainer'>
                <button className="tiny-btn btn btn-primary" onClick={() => premuto()}>Oggi</button>
                <h4 className='titolo'>{giorno.toLocaleDateString()}</h4>
            </div>
            <div className='overflow-y-auto verocard'>
                <div>
                    {carta}
                    {carta}
                    {carta}
                    {carta}
                    {carta}
                </div>
            </div>
        </div>
    );
};
