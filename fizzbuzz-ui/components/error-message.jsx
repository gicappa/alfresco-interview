import React, {useEffect, useState} from "react";

const ErrorMessage = (props) => {

  const [data, setData] = useState({})

  useEffect(() => {
    props.store.emitter().on('redraw', setResult);

    return function cleanup() {
      props.store.emitter().removeListener('redraw', setResult);
    };
  })

  const setResult = (_data) => {
    console.log("FizzbuzzResponse.on: ", _data);
    setData(_data);
  }

  const error = () => {
    if ("error" in data) {
      return data.error.message;
    } else {
      return "";
    }
  }

  return (
    <div className="text-red-500 text-sm">{error()}</div>
  );
}

export default ErrorMessage;