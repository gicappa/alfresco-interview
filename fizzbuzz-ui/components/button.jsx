import React from 'react';

function Button(props) {
    const buttonClass = 'w-full flex items-center justify-center px-8 ' +
        'py-3 border border-transparent text-lg text-white bg-indigo-600 ' +
        'hover:bg-indigo-700 font-semibold rounded-md md:py-4 md:text-lg md:px-10';

    return (
        <div className="rounded-md shadow">
            <a onClick={props.onClick}
               href={props.href ? props.href : "#"}
               rel="noopener noreferrer"
               className={buttonClass}>
                {props.text}
            </a>
        </div>
    );
}

export default Button;
