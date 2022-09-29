import {useEffect, useState} from "react";

const UNKNOWN = "UNKNOWN"

function Convert() {

    const [rates, setRates] = useState(UNKNOWN);

    useEffect(() => {
        fetch('api/v1/rates')
            .then((response) => response.text())
            .then((data) => {
                setRates(data);
            })
    });


    return (
        <div>
            <h1>rates: {rates}</h1>
        </div>
    );
}

export default Convert;