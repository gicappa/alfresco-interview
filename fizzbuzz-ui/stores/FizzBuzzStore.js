import {getWordsService} from "../services/WordsService";

function FizzBuzzStore(emitter) {
  this.e = emitter;
  this.limit = 20;
  this.words = [];
  this.menuItems = [
    {"name": "Docs", "link": "/"},
    {"name": "Rest APIs", "link": "/q/swagger-ui"},
    {"name": "JavaDoc", "link": "/javadoc"},
    {"name": "Code Coverage", "link": "/jacoco"}
  ];
  this.popupVisible = false;
}

FizzBuzzStore.prototype.loadWords = async function () {
  console.log("FizzBuzzStore.loadWords");

  const wordsResponse = await getWordsService(this.limit);
  this.words.push(wordsResponse);
  this.e.emit('redraw', wordsResponse);
}

FizzBuzzStore.prototype.emitter = function () {
  console.log("FizzBuzzStore.prototype.emitter", this);
  return this.e;
}

FizzBuzzStore.prototype.getMenuItems = function () {
  return this.menuItems;
}

FizzBuzzStore.prototype.isPopupVisible = function () {
  return this.popupVisible;
}

FizzBuzzStore.prototype.setPopupVisible = function () {
  this.popupVisible = true;
  this.e.emit('redraw', {popupVisible: this.popupVisible});
}
FizzBuzzStore.prototype.setPopupHidden = function () {
  this.popupVisible = false;
  this.e.emit('redraw', {popupVisible: this.popupVisible});
}

FizzBuzzStore.prototype.getWords = function () {
  return this.words;
}

FizzBuzzStore.prototype.setLimit = function (limit) {
  this.limit = limit
}

export default FizzBuzzStore;
