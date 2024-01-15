import { useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        <div className="container">
            <div className="row my-4">
                <div className="col-md-3">
                    <Calendario giorno={giorno} setGiorno={setGiorno} />
                </div>
                <div className="col-md-3">
                    <Agenda giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
            <div>
                <DettagliPreno giorno={giorno} setGiorno={setGiorno} />
            </div>
        </div>
    );
};
