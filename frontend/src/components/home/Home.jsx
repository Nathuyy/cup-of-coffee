import React from "react";
import Main from "../template/Main";


export default (props) => (
    <Main
      icon="home"
      title="Home"
    >
      <div className="display-4">Bem Vindo!</div>
      <hr />
      <p className="mb-0">
        Sistema para exemplificar a construção de uma cafeteria virtual desenvolvido em
        React e Java Spring Boot!
      </p>
    </Main>
  );