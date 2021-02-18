import axios from 'axios';

export const http_get = async (service, params) => {
  let response = await axios.get(
    getServiceURL(service),
    {
      headers: {
        'Content-Type': 'application/json'
      },
      params: params
    });

  return response.data;
};


/**
 * returns the caller url
 * WARNING this is a kind of hack and it should not be
 * used in production environment
 *
 * @param service
 * @returns {string}
 */
const getServiceURL = service => {
  return getHost().concat(service);
};

const getHost = () => {

  return "http://localhost:8080";
  //return window.location.protocol.concat("//").concat(window.location.host);
};
