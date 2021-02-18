import React from 'react';
import HeroTitle from './hero-title';
import HeroClaim from './hero-claim';
import Button from './button';
import LimitField from "./limitfield";
import ErrorMessage from "./error-message";

function Hero(props) {

  function handleClick() {
    props.store.loadWords()
  }

  return (
    <main className="mt-10 mx-auto max-w-7xl px-4 sm:mt-12 sm:px-6 md:mt-16 lg:mt-20 lg:px-8 xl:mt-28">
      <div className="sm:text-center lg:text-left">
        <HeroTitle title="FizzBuzz" subtitle="Alfresco Interview"/>
        <HeroClaim claim="Secure Content Management Solutions"/>
        <div className="mt-5 sm:mt-8 sm:flex sm:justify-center lg:justify-start">
          <Button text="FizzBuzz Me Up!" onClick={handleClick}/>
          <LimitField store={props.store}/>
        </div>
        <div className="sm:flex sm:justify-center lg:justify-start">
          <ErrorMessage store={props.store}/>
        </div>
      </div>
    </main>
  );
}

export default Hero;
