import { useEffect, useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";
import axios from "axios";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date().getTime());
    const [prenotazioni, setPrenotazioni] = useState([]);
    const [prenotazione, setPrenotazione] = useState({
        id: 0,
        ufficio: 0,
        stanza: 0,
        createUser: 0,
        createDate: 0,
        editUser: 0,
        utente: 0,
        postazione: 0,
        editDate: 0,
        dataPrenotazione: 0,
    });

    const fetch = () => {
        axios
            .post(
                "http://localhost:9890/prenotazione/filter",
                {
                    inizioPeriodo: giorno,
                    finePeriodo: giorno,
                },
                { headers: { "Content-Type": "application/json" } }
            )
            .then((response) => setPrenotazioni(response.data))
            .catch((err) => console.log(err));
    };

    useEffect(fetch, [giorno]);

    return (
        <div className="container my-5" style={{ width: "50%" }}>
            <div className="row">
                <div className="col-md-6">
                    <Calendario giorno={giorno} setGiorno={setGiorno} />
                </div>
                <div className="col-md-6">
                    <Agenda
                        giorno={giorno}
                        setGiorno={setGiorno}
                        prenotazione={setPrenotazione}
                        prenotazioni={prenotazioni}
                    />
                </div>
            </div>
            <div className="row my-2">
                <div className="col-md-12">
                    <DettagliPreno giorno={giorno} prenotazione={prenotazione} />
                </div>
            </div>
        </div>
    );
};
