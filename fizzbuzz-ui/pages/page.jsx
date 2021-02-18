import React from 'react';
import NavBar from '../components/navbar';
import NavBarPopup from '../components/navbar-popup';
import Hero from '../components/hero';
import Footer from '../components/footer';
import Head from 'next/head';
import FizzbuzzResponse from "../components/fizzbuzz-response";

function Page(props) {
    return (
        <>
            <Head>
                <title>FizzBuzz</title>
                <link rel="shortcut icon" href="/favicon.ico"/>
            </Head>
            {/*<div className="relative bg-white overflow-hidden">*/}
                <div className="max-w-7xl mx-auto">
                    <div
                        className="relative z-10 pb-8 bg-white sm:pb-16 md:pb-20 lg:max-w-2xl lg:w-full lg:pb-28 xl:pb-32">
                        <div className="relative pt-6 px-4 sm:px-6 lg:px-8">
                            <NavBar/>
                        </div>
                        <NavBarPopup/>
                        <Hero store={props.store}/>
                    </div>
                </div>
                <FizzbuzzResponse store={props.store}/>
            {/*</div>*/}
            <Footer/>
        </>
    );
}

export default Page;
