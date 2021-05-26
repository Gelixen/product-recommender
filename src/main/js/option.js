import React from 'react';

function Option(props) {
    return (
        <div>
            <label>{props.question}</label>
            <select name={props.id} onChange={e => props.onChangeHandler(e)}>
                {props.options.map(income => (
                    <option key={income.name} value={income.name}>
                        {income.description}
                    </option>
                ))}
            </select>
        </div>
    );
}

export default Option;