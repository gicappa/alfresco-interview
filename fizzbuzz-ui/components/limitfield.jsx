import React, {useEffect, useState} from 'react';

function LimitField(props) {

  const inputClass = () => {
    return `input border border-${color()}-300 bg-${color()}-100 appearance-none rounded-md w-full px-3 py-3 pt-5 pb-3 focus focus:border-${color()}-600 focus:outline-none active:outline-none active:border-${color()}-600 text-center text-xl`;
  };

  const labelClass = () => {
    return `label absolute mb-0 -mt-3 pt-4 pl-3 leading-tighter text-${color()}-400 text-sm mt-2 cursor-text`;
  }

  const [valid, setValid] = useState(true);

  useEffect(() => {
    props.store.emitter().on('redraw', signalError);

    return function cleanup() {
      props.store.emitter().removeListener('redraw', signalError);
    };
  })

  const signalError = (_data) => {
    setValid(!("error" in _data));
  }

  const onChange = (event) => {
    props.store.setLimit(event.target.value)
  }

  const color = () => {
    return valid ? "indigo" : "red";
  }

  return (
    <div className={`mt-3 sm:mt-0 sm:ml-3 text-${color()}-700`}>
      <label htmlFor="limit" className={labelClass()}>
        Limit
      </label>

      <input id="limit" type="text" autoFocus className={inputClass()}
             onFocus={onChange} onChange={onChange}/>

    </div>
  );
}

export default LimitField;
