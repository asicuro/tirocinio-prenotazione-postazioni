import { useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";
import DettagliPreno from "./Dettagli";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        //TODO sistemare positioning
        <div className="container my-5" style={{ width: "50%" }}>
            <div className="row">
                <div className="col-md-6">
                    <Calendario giorno={giorno} setGiorno={setGiorno} />
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
