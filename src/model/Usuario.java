package model;

/**
 * Classe Abstrata Usuario
 * Define atributos e comportamentos comuns a todos os usuários do sistema
 * Não pode ser instanciada diretamente (é abstrata)
 * Serve como base para Aluno, Professor e Administrador
 * IMPLEMENTA Relatorio (interface) - Fase 6
 * 
 * (Fase 5: Interfaces e Abstração)
 * (Fase 6: Relatórios e Polimorfismo)
 */
public abstract class Usuario implements Autenticavel, Relatorio {
    
    // ========== ATRIBUTOS PROTEGIDOS ==========
    // protected: acessível pelas subclasses
    protected String nome;
    protected String login;
    protected String senha;
    
    /**
     * Construtor da classe abstrata Usuario
     * @param nome - Nome do usuário
     * @param login - Login único do usuário
     * @param senha - Senha do usuário
     */
    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    // ========== GETTERS ==========
    
    public String getNome() {
        return nome;
    }
    
    public String getLogin() {
        return login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    // ========== SETTERS ==========
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    // ========== MÉTODOS ABSTRATOS ==========
    
    /**
     * Método abstrato que DEVE ser implementado pelas subclasses
     * Cada tipo de usuário pode ter regras diferentes de autenticação
     */
    @Override
    public abstract boolean autenticar(String login, String senha);
    
    /**
     * Método abstrato que DEVE ser implementado pelas subclasses
     * Retorna o tipo/perfil do usuário
     */
    public abstract String obterPerfil();
    
    /**
     * Método abstrato que DEVE ser implementado pelas subclasses
     * Gera um relatório com informações da entidade (Fase 6)
     * (Implementa interface Relatorio)
     */
    @Override
    public abstract void gerarRelatorio();
    
    /**
     * Retorna uma representação em String do usuário
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", perfil='" + obterPerfil() + '\'' +
                '}';
    }
}