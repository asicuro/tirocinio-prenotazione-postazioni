import { useState } from "react";

const Counter = () => {
    const [count, setCount] = useState(0);

    return (
        <div className="mt-5 px-3 py-4">
            <h1 className="h1 display-1">Contatore</h1>
            <h2 className="h1 display-1 mt-5 mb-3">{count}</h2>
            <div className="mt-5">
                <button
                    className="btn btn-danger btn-lg mx-3 px-5 py-3 mt-2"
                    onClick={() => setCount(count + 1)}
                >
                    +
                </button>
            </div>
        </div>
    );
};
export default Counter;
