import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css";
import PropTypes from "prop-types";

export const Calendario = ({ giorno, setGiorno, prenotazioni }) => {
    const disponibilita =
        prenotazioni.length === 0
            ? "disponibile"
            : prenotazioni.length < 3
            ? "poca-disponibilita"
            : "non-disponibile";

    return (
        <Calendar
            onClickDay={setGiorno}
            selectRange={false}
            allowPartialRange={false}
            minDetail="year"
            value={giorno}
            className={disponibilita}
        />
    );
};

Calendario.propTypes = {
    giorno: PropTypes.instanceOf(Date).isRequired,
    setGiorno: PropTypes.func.isRequired,
    prenotazioni: PropTypes.arrayOf(PropTypes.instanceOf(Object)).isRequired,
};
