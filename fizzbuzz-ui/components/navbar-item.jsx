import React from 'react';

function NavbarItem(props) {
  return (
    <a href={props.link}
       className="font-medium text-gray-500 hover:text-gray-900">
      {props.text}
    </a>
  );
}

export default NavbarItem;
