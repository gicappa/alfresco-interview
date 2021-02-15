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

function NavBar() {
  return (
    <nav
      className="relative flex items-center justify-between sm:h-10 lg:justify-start"
      aria-label="Global"
    >
      <div className="flex items-center flex-grow flex-shrink-0 lg:flex-grow-0">
        <div className="flex items-center justify-between w-full md:w-auto">
          <a href="#">
            <span className="sr-only">Workflow</span>
            <img className="h-8 w-auto sm:h-10" src="/logo.png" alt="Logo" />
          </a>
          <div className="-mr-2 flex items-center md:hidden">
            <button
              type="button"
              className="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
              id="main-menu"
              aria-haspopup="true"
            >
              <span className="sr-only">Open main menu</span>

              <svg
                className="h-6 w-6"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
                aria-hidden="true"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={2}
                  d="M4 6h16M4 12h16M4 18h16"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>
      <div className="hidden md:block md:ml-10 md:pr-4 md:space-x-8">
        <NavbarItem text="Home" link="/" />
        <NavbarItem text="Docs" link="/" />
        <NavbarItem text="Code Coverage" link="/" />
        <NavbarItem text="Rest APIs" link="/q/swagger-ui" />
      </div>
    </nav>
  );
}

export default NavBar;
