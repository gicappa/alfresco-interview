import {getWordsService} from "../services/WordsService";

function FizzBuzzStore(emitter) {
    this.e = emitter;
    this.limit = 20;
    this.words = [];
}

FizzBuzzStore.prototype.getWords = function () {
    return this.words;
}

FizzBuzzStore.prototype.loadWords = async function () {
    console.log("FizzBuzzStore.loadWords = async ()");

    const wordsResponse = await getWordsService(this.limit);

    this.words.push(wordsResponse);

    this.e.emit('redraw', wordsResponse);
}

FizzBuzzStore.prototype.emitter = function () {
    console.log("FizzBuzzStore.prototype.emitter", this);
    return this.e;
}

FizzBuzzStore.prototype.setLimit = function (limit) {
    this.limit = limit
}

export default FizzBuzzStore;
