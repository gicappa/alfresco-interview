import React from 'react';

function HeroTitle(props) {
  return (
    <h1 className="text-4xl tracking-tight font-extrabold text-gray-900 sm:text-5xl md:text-6xl">
      <span className="block">{props.title}</span>
      <span className="text-4xl block text-indigo-600 xl:inline">
        {props.subtitle}
      </span>
    </h1>
  );
}

export default HeroTitle;
