import React, {useEffect, useState} from 'react';

function NavBarPopup(props) {

  const [visible, setVisible] = useState(false);

  useEffect(() => {
    props.store.emitter().on('redraw', setVisibility);
    return function cleanup() {
      props.store.emitter().removeListener('redraw', setVisibility);
    };
  })

  const setVisibility = () => {
    setVisible(props.store.isPopupVisible());
  }

  const handleClick = () => {
    props.store.setPopupHidden();
  }

  const popupClass = () => {
    return "absolute top-0 inset-x-0 p-2 transition transform origin-top-right h-full " + (visible ? "" : "hidden")
  }

  return (
    <div className={popupClass()}>
      <div className="rounded-lg shadow-md bg-white ring-1 ring-black ring-opacity-5 overflow-hidden">
        <div className="px-5 pt-4 flex items-center justify-between">
          <div>
            <img className="h-8 w-auto" src="/logo.png" alt="Alfresco Logo"/>
          </div>
          <div className="-mr-2">
            <button type="button"
                    className="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500"
                    onClick={handleClick}>
              <span className="sr-only">Close main menu</span>

              <svg className="h-6 w-6"
                   xmlns="http://www.w3.org/2000/svg"
                   fill="none"
                   viewBox="0 0 24 24"
                   stroke="currentColor"
                   aria-hidden="true">
                <path strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth={2}
                      d="M6 18L18 6M6 6l12 12"/>
              </svg>
            </button>
          </div>
        </div>
        <div role="menu" aria-orientation="vertical" aria-labelledby="main-menu">
          <div className="px-2 pt-2 pb-3 space-y-1" role="none">
            <div className="md:block md:ml-10 md:pr-4 md:space-x-8">
              {props.menu.items.map((item, index) =>
                (<a href={item.link}
                    key={index}
                    className="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50"
                    role="menuitem">{item.name}</a>)
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default NavBarPopup;
