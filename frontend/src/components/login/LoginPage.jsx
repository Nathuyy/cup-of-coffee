import React, { useState } from 'react';
import api from '../../axiosConfig'; 
import './LoginPage.css'

const Login = () => {
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [message, setMessage] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();

        try {
            const response = await api.post('/auth/login', {
                email,
                senha,
            });

            console.log(response);

            const token = response.data.token;
            console.log(token);
            
            api.defaults.headers.common['Authorization'] = `Bearer ${token}`;

            alert('Login com sucesso');
            setMessage('Login bem-sucedido');
        } catch (error) {
            setMessage('Erro ao fazer login. Verifique suas credenciais.');
            console.error('Login falhou', error);
        }
    };

    return (
        <div className="login-page">
            <div className="form">
                <h2>Login</h2>
                <form onSubmit={handleLogin}>
                    <div>
                        <label>Email:</label>
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <label>Senha:</label>
                        <input
                            type="password"
                            value={senha}
                            onChange={(e) => setSenha(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit">Login</button>
                </form>
                {message && <p className="message">{message}</p>}
            </div>
        </div>
    );
};

export default Login;
