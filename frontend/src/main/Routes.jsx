import React from "react"
import { Routes, Route, Navigate } from 'react-router-dom'

import Home from '../components/home/Home'
import FormularioCadastro  from '../components/cadastrar/FormularioCadastro'
import LoginPage from '../components/login/LoginPage'

function AppRoutes() {
    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/register" element={<FormularioCadastro />} />
            <Route path="/login" element={<LoginPage />} />
            <Route path="*" element={<Navigate to="/" />} />
        </Routes>
    );
}

export default AppRoutes;