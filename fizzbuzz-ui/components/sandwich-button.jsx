import SandwichIcon from "./sandwich-icon";

const SandwichButton = (props) => {
  const handleClick = () => {
    console.log("NavBar.handleClick-setPopupVisible")
    props.store.setPopupVisible();
  }

  return (
    <button
      type="button"
      className="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
      id="main-menu"
      aria-haspopup="true"
      onClick={handleClick}>
      <span className="sr-only">Open main menu</span>
      <SandwichIcon/>
    </button>
  );
}

export default SandwichButton;