import React from "react";

function ObliqueWhiteStripe() {
    return (
        <svg
            className="hidden lg:block absolute right-0 inset-y-0 h-full w-48 text-white transform translate-x-1/2"
            fill="currentColor"
            viewBox="0 0 100 100"
            preserveAspectRatio="none"
            aria-hidden="true">
            <polygon points="50,0 85,0 50,100 15,100"/>
        </svg>
    );
}

export default ObliqueWhiteStripe;