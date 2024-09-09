import React, { useState } from "react"
import axios from "axios"
import './FormularioCadastro.css'

const FormularioCadastro = () => {
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [role] = useState("USER");
    const [message, setMessage] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/auth/register", {
                email: email,
                role: role,
                senha: senha
            });
            console.log(response);
            setMessage("Usuário cadastrado com sucesso!");
        } catch (error) {
            if (error.response) {
                setMessage(error.response.data);
            } else {
                setMessage("Erro ao enviar formulário: " + error.message);
            }
            alert("Erro ao enviar formulário");
        }
    };

    return (
        <div className="login-page">
            <div className="form">
                <h2>Cadastro de Usuário</h2>
                <form onSubmit={handleSubmit}>
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
                    <button type="submit">Cadastrar</button>
                </form>
                {message && <p className="message">{message}</p>}
            </div>
        </div>
    );
};

export default FormularioCadastro;