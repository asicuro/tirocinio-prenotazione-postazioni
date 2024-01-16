import { useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        //TODO sistemare positioning
        <div className="container my-5">
            <div className="row">
                <div className="col-md-3">
                    <Calendario giorno={giorno} setGiorno={setGiorno} />
                </div>
                <div className="col-md-4 mx-3">
                    <Agenda giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
            <div className="row my-3">
                <div className="col-md-10">
                    <DettagliPreno giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
        </div>
    );
};
