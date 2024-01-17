import { useEffect, useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";
import axios from "axios";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());
    const [prenotazioni, setPrenotazioni] = useState([]);

    const fetch = () => {
        axios
            .post(
                "http://localhost:9890/prenotazione/filter",
                {
                    inizioPeriodo: giorno.toJSON(),
                    finePeriodo: giorno.toJSON(),
                },
                { headers: { "Content-Type": "application/json" } }
            )
            .then((response) => setPrenotazioni(response.data))
            .catch((err) => console.log(err));
    };

    console.clear();
    useEffect(fetch, [giorno]);
    prenotazioni.map((p) => console.log(p));

    return (
        <div className="container my-5" style={{ width: "50%" }}>
            <div className="row">
                <div className="col-md-6">
                    <Calendario
                        giorno={giorno}
                        setGiorno={setGiorno}
                        prenotazioni={prenotazioni}
                    />
                </div>
                <div className="col-md-6">
                    <Agenda giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
            <div className="row my-2">
                <div className="col-md-12">
                    <DettagliPreno giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
        </div>
    );
};
