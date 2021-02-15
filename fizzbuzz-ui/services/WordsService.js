import {http_get} from '../api/API';


/**
 *  words service to access the words resource
 *
 * @param limit the upper bound of the fizzbuzz sequence
 * @returns {string}
 */
export const getWordsService = async (limit) => {

    const words = await http_get("/words", {"limit": limit});

    console.log("returned: ", words);

    if (!words)
        return;

    return words;
}