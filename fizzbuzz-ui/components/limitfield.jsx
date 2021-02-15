import React from 'react';
import FizzBuzzStore from "../stores/FizzBuzzStore";

function LimitField(props) {
    const cn = "input border border-indigo-300 appearance-none rounded-md w-full px-3 py-3 pt-5 pb-4 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600 text-center";

    let onChange = (event) => {
        FizzBuzzStore.setLimit(event.target.value)
    }

    return (
        <div className="text-indigo-700 bg-indigo-100 mt-3 sm:mt-0 sm:ml-3">
            <label htmlFor="limit"
                   className="label absolute mb-0 -mt-3 pt-4 pl-3 leading-tighter text-indigo-400 text-sm mt-2 cursor-text">
                Limit
            </label>

            <input id="limit" type="text" autoFocus className={cn}
            onFocus={onChange} onChange={onChange}/>

        </div>
    );
}

export default LimitField;
