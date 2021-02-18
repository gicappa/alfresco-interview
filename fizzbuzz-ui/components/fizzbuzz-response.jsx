import React, {useEffect, useState} from 'react';

const FizzbuzzResponse = (props) => {
  const styles = {
    olClass: "gradient-list w-11/12 lg:absolute lg:top-20 " +
      "lg:text-3xl md:text-2xl sm:text-xl lg:left-150 " +
      "text-indigo-700 m-auto",
    containerClass: "lg:absolute lg:inset-y-0 lg:right-0 " +
      "lg:w-1/2 overflow-y-scroll bg-logo-alfresco " +
      "bg-right-top bg-no-repeat min-h-full h-96"
  }

  const [data, setData] = useState({words: []})

  useEffect(() => {
    props.store.emitter().on('redraw', (_data) => {
      console.log("FizzbuzzResponse.on: ", _data);
      setData(_data);
    })
  })

  return (
    <div className={styles.containerClass}>
      <ol className={styles.olClass}
          style={{left: 150}}>
        {data.words.map((word, index) =>
          (<li className="w-9/12" key={index}>{word}</li>)
        )}
      </ol>
    </div>
  );
}

export default FizzbuzzResponse;