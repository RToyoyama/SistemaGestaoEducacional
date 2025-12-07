package model;

/**
 * Interface Autenticavel
 * Define o contrato para classes que precisam autenticar usuários
 * Qualquer classe que implemente esta interface DEVE ter um método autenticar()
 * 
 * (Fase 5: Interfaces e Abstração)
 */
public interface Autenticavel {
    
    /**
     * Autentica um usuário com login e senha
     * 
     * @param login - Login do usuário
     * @param senha - Senha do usuário
     * @return true se as credenciais estão corretas, false caso contrário
     */
    boolean autenticar(String login, String senha);
    
}