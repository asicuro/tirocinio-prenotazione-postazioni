import { useState } from "react";
import { Calendario } from "./Calendario";

export const Dashboard = () => {
    const [giorno, setGiorno] = useState(new Date());

    return (
        <div className="App">
            <Calendario setGiorno={setGiorno} />
        </div>
    );
};
