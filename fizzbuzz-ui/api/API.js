import axios from 'axios';

export const http_get = async (service, params) => {
    try {
        let response = await axios.get(
            getServiceURL(service),
            {
                headers: {
                    'Content-Type': 'application/json'
                },
                params: params
            });

        return response.data;
    } catch (error) {
        console.error("request GET " + getServiceURL(service) + " failed.");
        return handleError(error);
    }
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

const handleError = (error) => {
    if (error.response) {
        /*
         * The request was made and the server responded with a
         * status code that falls out of the range of 2xx
         */
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
        return new Error(error.response.status, error.response.data.error);
    } else if (error.request) {
        /*
         * The request was made but no response was received, `error.request`
         * is an instance of XMLHttpRequest in the browser and an instance
         * of http.ClientRequest in Node.js
         */
        console.log(error.request);
        return new Error(1, "Unable to reach the server: " + error.message);
    } else {
        // Something happened in setting up the request and triggered an Error
        console.log(error.message);
        return new Error(-1, "Unknown error : " + error.message);
    }
}
