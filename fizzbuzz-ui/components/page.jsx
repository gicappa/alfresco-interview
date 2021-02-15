import React from 'react';
import NavBar from './navbar';
import NavBarPopup from './navbar-popup';
import Hero from './hero';
import Footer from './footer';
import Head from 'next/head';

function Page() {
  return (
    <>
      <Head>
        <title>FizzBuzz Example</title>
        <link rel="shortcut icon" href="/favicon.ico" />
        <link rel="stylesheet" src="/tailwind.css" />
      </Head>
      <div className="relative bg-white overflow-hidden">
        <div className="max-w-7xl mx-auto">
          <div className="relative z-10 pb-8 bg-white sm:pb-16 md:pb-20 lg:max-w-2xl lg:w-full lg:pb-28 xl:pb-32">
            <svg
              className="hidden lg:block absolute right-0 inset-y-0 h-full w-48 text-white transform translate-x-1/2"
              fill="currentColor"
              viewBox="0 0 100 100"
              preserveAspectRatio="none"
              aria-hidden="true"
            >
              <polygon points="50,0 100,0 50,100 0,100" />
            </svg>
            <div className="relative pt-6 px-4 sm:px-6 lg:px-8">
              <NavBar />
            </div>
            <NavBarPopup />
            <Hero />
          </div>
        </div>
        <div className="lg:absolute lg:inset-y-0 lg:right-0 lg:w-1/2">
          <img
            className="h-56 w-full object-cover sm:h-72 md:h-96 lg:w-full lg:h-full"
            src="/hero-image.jpeg"
            alt="Hero Image"
          />
        </div>
      </div>
      <Footer />
    </>
  );
}

export default Page;
