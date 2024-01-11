import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css";

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
