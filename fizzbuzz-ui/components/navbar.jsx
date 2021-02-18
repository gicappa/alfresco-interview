/*
Mobile menu, show/hide based on menu open state.

Entering: "duration-150 ease-out"
From: "opacity-0 scale-95"
To: "opacity-100 scale-100"
Leaving: "duration-100 ease-in"
From: "opacity-100 scale-100"
To: "opacity-0 scale-95"
*/

import React from 'react';
import NavbarItem from './navbar-item';
import SandwichButton from "./sandwich-button";

function NavBar(props) {

  return (

    <nav
      className="relative flex items-center justify-between sm:h-10 lg:justify-start pt-6 px-4 sm:px-6 lg:px-8"
      aria-label="Global">
      <div className="flex items-center flex-grow flex-shrink-0 lg:flex-grow-0">
        <div className="flex items-center justify-between w-full md:w-auto">
          <a href="#">
            <span className="sr-only">Workflow</span>
            <img className="h-8 w-auto sm:h-10" src="/logo.png" alt="Logo"/>
          </a>
          <div className="-mr-2 flex items-center md:hidden">
            <SandwichButton store={props.store}/>
          </div>
        </div>
      </div>
      <div className="hidden md:block md:ml-10 md:pr-4 md:space-x-8">
        {props.store.getMenuItems().map((item, index) =>
          (<NavbarItem key={index} text={item.name} link={item.link}/>)
        )}
      </div>
    </nav>
  );
}

export default NavBar;
