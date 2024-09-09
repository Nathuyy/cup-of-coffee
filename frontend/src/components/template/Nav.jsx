import './Nav.css';
import React from 'react';
import { Link } from 'react-router-dom';

export default props => (
    <>
        <aside className='menu-area'>
            <nav className='menu'>
                <Link to="/">
                    <i className='fa fa-home'></i> Home
                </Link>
                <Link to="/login">
                    <i className="fa-solid fa-right-to-bracket"></i> Login
                </Link>
                <Link to="/register">
                    <i className='fa-solid fa-user'></i> Cadastro
                </Link>
            </nav>
        </aside>
    </>
);
