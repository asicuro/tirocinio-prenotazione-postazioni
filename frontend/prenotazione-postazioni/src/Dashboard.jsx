import { useState } from "react";
import { Calendario } from "./Calendario";
import { Agenda } from "./Agenda";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        <div>
            <Calendario giorno={giorno} setGiorno={setGiorno} />
            <Agenda giorno={giorno} setGiorno={setGiorno} />
        </div>
    );
};
