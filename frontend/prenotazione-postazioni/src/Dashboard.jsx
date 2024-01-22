import { useEffect, useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";
import axios from "axios";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date().getTime());
    const [prenotazioni, setPrenotazioni] = useState([]);
    const [prenotazione, setPrenotazione] = useState({
        id: null,
        ufficio: null,
        stanza: null,
        createUser: null,
        createDate: null,
        editUser: null,
        utente: null,
        postazione: null,
        editDate: null,
        dataPrenotazione: null,
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
                        setPrenotazione={setPrenotazione}
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
