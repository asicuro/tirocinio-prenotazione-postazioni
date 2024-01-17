import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css";
import PropTypes from "prop-types";
import { useState, useEffect } from "react";
import axios from "axios";

export const Calendario = ({ giorno, setGiorno, prenotazioni }) => {
    const [prenotazioniTutte, setPrenotazioniTutte] = useState([]);

    /* const fetchTutte = () => {
        axios
            .get("http://localhost:9890/prenotazione/all")
            .then((response) => setPrenotazioniTutte(response.data))
            .catch((err) => console.log(err));
    };

    console.clear();
    useEffect(fetchTutte); */

    const disponibilita =
        prenotazioni.length === 0
            ? "disponibile"
            : prenotazioni.length < 3
            ? "poca-disponibilita"
            : "non-disponibile";

    /* const disponibilitaMese = ({ date, view }) => {
        if (view === "month" && date.getDate() === 15) {
            return "poca-disponibilita";
        }
    }; */

    return (
        <Calendar
            onClickDay={setGiorno}
            selectRange={false}
            allowPartialRange={false}
            minDetail="year"
            value={giorno}
            className={disponibilita}
            //tileClassName={disponibilitaMese}
        />
    );
};

Calendario.propTypes = {
    giorno: PropTypes.instanceOf(Date).isRequired,
    setGiorno: PropTypes.func.isRequired,
    prenotazioni: PropTypes.arrayOf(PropTypes.instanceOf(Object)).isRequired,
};
