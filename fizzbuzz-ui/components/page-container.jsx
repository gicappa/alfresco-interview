import React from "react";

const PageContainer = (props) => {

  const styles = {
    menuPageClass1: "max-w-7xl mx-auto",
    menuPageClass2: "relative z-10 pb-8 bg-white " +
      "sm:pb-16 md:pb-20 lg:max-w-2xl lg:w-full " +
      "lg:pb-28 xl:pb-32",
  }

  return (
    <div className={styles.menuPageClass1}>
      <div
        className={styles.menuPageClass2}>
        {props.children}
      </div>
    </div>

  )
}

export default PageContainer;