import './Logo.css'
import React from 'react'
import logo from '../../assets/images/logo.webp'


export default props => 
    <aside className='logo'>
        <img src={logo} alt='coffee' />
    </aside>