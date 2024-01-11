import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css";
import PropTypes from "prop-types";

export const Calendario = ({ giorno, setGiorno }) => {
    return (
        <div className="main-container mx-5 my-5">
            <Calendar
                onClickDay={setGiorno}
                selectRange={false}
                allowPartialRange={false}
                minDetail="year"
                value={giorno}
            />
        </div>
    );
};

Calendario.propTypes = {
    giorno: PropTypes.instanceOf(Date).isRequired,
    setGiorno: PropTypes.func.isRequired,
};
