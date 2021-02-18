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

function getHostname() {
  return window.location.hostname;
}

function getProtocol() {
  return window.location.protocol;
}

function getPort() {
  return window.location.port;
}

/**
 * This functions uses the same host used to connect to the server as an
 * API host.
 * Moreover, if the process serving the page is the development one
 * (served by npm run dev) it uses http://localhost:8080 as server API
 * In this way using the mvn quarkus:dev will start the server on the
 * returned address serving the APIs to develop the UI.
 *
 * @returns {string}
 */
const getHost = () => {
  if (process.env.NODE_ENV === 'development') {
    console.log("detected development mode: page served by npm run dev");
    if (getHostname().includes("localhost")) {
      return "http://localhost:8080";
    }

  }

  return getProtocol()
    .concat("//")
    .concat(getHostname())
    .concat(":")
    .concat(getPort());
};
