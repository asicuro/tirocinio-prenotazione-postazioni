import { useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        //TODO sistemare positioning
        <div className="container">
            <div className="row my-2 justify-content-center">
                <div className="col-md-3 my-3">
                    <Calendario giorno={giorno} setGiorno={setGiorno} />
                </div>
                <div className="col-md-3 my-3">
                    <Agenda giorno={giorno} setGiorno={setGiorno} />
                </div>
            </div>
            <div className="row justify-content-center">
                <DettagliPreno giorno={giorno} setGiorno={setGiorno} />
            </div>
        </div>
    );
};
