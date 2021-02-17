import React, {useEffect, useState} from 'react';

const FizzbuzzResponse = (props) => {

  const [words, setWords] = useState({words: []})

  useEffect(() => {
    props.store.emitter().on('redraw', (data) => {
      console.log("FizzbuzzResponse received: ", data);
      setWords(data.words);
    })
  })

  return (
    <div className="lg:absolute lg:inset-y-0 lg:right-0 lg:w-1/2 bg-indigo-300 overflow-y-scroll">
      <h1 className="lg:absolute text-indigo-700 font-extrabold tracking-tight" style={{left: 150}}>FizzBuzz
        Response</h1>
      <ol className="gradient-list w-11/12 lg:absolute lg:top-20 lg:text-3xl
      md:text-xl sm:text-lg lg:left-150 text-indigo-700"
          style={{left: 150}}>
        {words.map((word, index) =>
          (<li className="w-9/12" key={index}>{word}</li>)
        )}
      </ol>
    </div>
  );
}

export default FizzbuzzResponse;