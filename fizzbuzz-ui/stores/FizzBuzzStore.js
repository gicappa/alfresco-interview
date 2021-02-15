let _limit = 20

function FizzBuzzStore() {
}

FizzBuzzStore.setLimit = (limit) => {
    _limit = limit
}

FizzBuzzStore.getLimit = () => {
    return _limit;
}

export default FizzBuzzStore;
