import React from 'react';
import Page from '../components/page';
import FizzBuzzStore from "../stores/FizzBuzzStore";

const fbStore = new FizzBuzzStore();

function Homepage() {
    return (
        <Page s={fbStore}/>
    );
}

export default Homepage;
