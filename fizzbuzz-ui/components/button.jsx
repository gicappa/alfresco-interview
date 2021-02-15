import React from 'react';

function Button(props) {
    const primary = 'text-white bg-indigo-600 hover:bg-indigo-700';
    const secondary = 'text-indigo-700 bg-indigo-100 hover:bg-indigo-200';

    let style = () => {
        return props.type === undefined || props.type === 'primary'
            ? {aClass: primary, divClass: 'rounded-md shadow'}
            : {aClass: secondary, divClass: 'mt-3 sm:mt-0 sm:ml-3'};
    };

    let spacedClass = () => {
        if (props.spaced) {
            return 'mt-3 sm:mt-0 sm:ml-3';
        }
    };

    return (
        <div className={`${style().divClass} ${spacedClass()}`}>
            <a onClick={props.onClick}
               href={props.href ? props.href : "#"}
               rel="noopener noreferrer"
               className={`w-full flex items-center justify-center px-8 py-3 border border-transparent text-base ${style().aClass} font-medium rounded-md md:py-4 md:text-lg md:px-10`}>
                {props.text}
            </a>
        </div>
    );
}

export default Button;
