import { useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        <div className="container">
            <div className="row my-5">
                <div className="col-md-3 mx-5">
                    <Calendario giorno={giorno} setGiorno={setGiorno} />
                </div>
                <div className="col-md-3 mx-5">
                    <Agenda giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
            <div className="row my-5">
                <DettagliPreno giorno={giorno} setGiorno={setGiorno} />
            </div>
        </div>
    );
};
