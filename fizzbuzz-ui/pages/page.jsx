import React from 'react';
import NavBar from '../components/navbar';
import NavBarPopup from '../components/navbar-popup';
import Hero from '../components/hero';
import Footer from '../components/footer';
import Head from 'next/head';
import FizzbuzzResponse from "../components/fizzbuzz-response";
import PageContainer from "../components/page-container";

function Page(props) {

  const styles = {
    mainClass: "relative bg-white overflow-hidden",
  }

  return (
    <>
      <Head>
        <title>FizzBuzz</title>
        <link rel="favicon" href="/favicon.ico"/>
      </Head>
      <div className={styles.mainClass}>
        <PageContainer>
          <NavBar store={props.store}/>
          <NavBarPopup store={props.store}/>
          <Hero store={props.store}/>
        </PageContainer>
        <FizzbuzzResponse store={props.store}/>
      </div>
      <Footer/>
    </>
  );
}

export default Page;
