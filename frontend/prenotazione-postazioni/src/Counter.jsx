import { useState } from "react";

const Counter = () => {
    const [count, setCount] = useState(0);

    const mainDiv = "mt-5 px-3 py-4";

    return (
        <div className={mainDiv}>
            <h1 className="h1 display-1">Contatore</h1>
            <h2 className="h1 display-4 mt-2 mb-3">{count}</h2>
            <div className="mt-5">
                <button
                    className="btn btn-danger btn-lg mx-3 px-5 py-3 mt-2"
                    onClick={() => setCount((count) => count + 1)}
                >
                    +1
                </button>
                <button
                    className="btn btn-info btn-lg mx-3 px-5 mt-2 py-3"
                    onClick={() => setCount((count) => count - 1)}
                >
                    -1
                </button>
                <button
                    className="btn btn-warning btn-lg mx-3 px-5 mt-2 py-3"
                    onClick={() => setCount(0)}
                >
                    Reset
                </button>
            </div>
        </div>
    );
};
export default Counter;
