import {useEffect, useState} from "react";

const UNKNOWN = "UNKNOWN"

function Rates() {

    const [date, setDate] = useState(UNKNOWN);
    const [rates, setRates] = useState(UNKNOWN);

    useEffect(() => {
        fetch('api/v1/rates')
            .then((response) => response.text())
            .then((data) => {
                setDate(data.date);
                setRates(data);
            })
    });


    return (
        <div>
            <h1>date: {date}</h1><br/>
            <h1>rates: {rates}</h1>
        </div>
    );
}

export default Rates;