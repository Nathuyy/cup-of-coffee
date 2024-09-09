import React from "react"
import { Routes, Route, Navigate } from 'react-router-dom'

import Home from '../components/home/Home'
import FormularioCadastro  from '../components/cadastrar/FormularioCadastro'

function AppRoutes() {
    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/register" element={<FormularioCadastro />} />
            <Route path="*" element={<Navigate to="/" />} />
        </Routes>
    );
}

export default AppRoutes;