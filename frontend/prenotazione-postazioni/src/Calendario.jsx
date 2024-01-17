import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css";
import PropTypes from "prop-types";
import { useEffect, useState } from "react";
import axios from "axios";

export const Calendario = ({ giorno, setGiorno }) => {
    const [prenotazioniTutte, setPrenotazioniTutte] = useState([]);

    useEffect(() => {
        axios
            .get("http://localhost:9890/prenotazione/all")
            .then((response) => {
                setPrenotazioniTutte(response.data);
            })
            .catch((err) => console.log(err));
    }, []);

    const getPrenotazioni = (data) => {
        const p = prenotazioniTutte.filter(
            (p) => p.dataPrenotazione === data.getTime()
        ).length;
        return p;
    };

    const disponibilita = ({ date, view }) => {
        if (view === "month") {
            return getPrenotazioni(date) === 0
                ? "disponibile"
                : getPrenotazioni(date) < 2
                ? "poca-disponibilita"
                : "non-disponibile";
        }
    };

    return (
        <Calendar
            onClickDay={setGiorno}
            selectRange={false}
            allowPartialRange={false}
            minDetail="year"
            value={giorno}
            showNeighboringMonth={false}
            tileClassName={disponibilita}
        />
    );
};

Calendario.propTypes = {
    giorno: PropTypes.instanceOf(Date).isRequired,
    setGiorno: PropTypes.func.isRequired,
};
