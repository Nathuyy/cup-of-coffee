import './Main.css'
import React from 'react'
import Header from './Header'

export default props =>
    <>
    <Header {...props}/>
        <main className='content conteiner-fluid'>
            <div className="p-3 mt-3">
                {props.children} 

            </div>    
        </main>
    

    
    </>