import React from 'react';
import Page from './page';
import FizzBuzzStore from "../stores/FizzBuzzStore";
import EventEmitter from "eventemitter3";

const store = new FizzBuzzStore(new EventEmitter());

function Homepage() {
    return (
        <Page store={store}/>
    );
}

export default Homepage;
