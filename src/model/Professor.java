package model;

/**
 * Classe que representa um Professor no sistema
 * HERDA de Usuario (classe abstrata)
 * IMPLEMENTA Autenticavel (interface)
 * IMPLEMENTA Relatorio (interface) - Fase 6
 * 
 * (Fase 5: Interfaces e Abstração)
 * (Fase 6: Relatórios e Polimorfismo)
 */
public class Professor extends Usuario {
    private String especialidade;
    private String registro;
    
    /**
     * Construtor da classe Professor
     * @param nome - Nome do professor
     * @param login - Login para autenticação
     * @param senha - Senha para autenticação
     * @param especialidade - Área de especialização
     * @param registro - Número único de registro
     */
    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        // Chama o construtor da classe PAI (Usuario)
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }
    
    // ========== GETTERS ==========
    
    public String getEspecialidade() {
        return especialidade;
    }
    
    public String getRegistro() {
        return registro;
    }
    
    // ========== SETTERS ==========
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
    // ========== IMPLEMENTANDO MÉTODOS DA INTERFACE AUTENTICAVEL ==========
    
    /**
     * IMPLEMENTA o método autenticar() da interface Autenticavel
     * Valida as credenciais do professor
     * 
     * @param login - Login fornecido
     * @param senha - Senha fornecida
     * @return true se login E senha estão corretos, false caso contrário
     */
    @Override
    public boolean autenticar(String login, String senha) {
        // Verifica se o login corresponde
        if (!this.login.equals(login)) {
            System.out.println("❌ Login inválido para professor!");
            return false;
        }
        
        // Verifica se a senha corresponde
        if (!this.senha.equals(senha)) {
            System.out.println("❌ Senha incorreta!");
            return false;
        }
        
        // Se chegou aqui, credenciais estão corretas
        System.out.println("✓ Professor " + nome + " autenticado com sucesso!");
        return true;
    }
    
    /**
     * IMPLEMENTA o método abstrato obterPerfil() da classe Usuario
     * 
     * @return String com o perfil do usuário
     */
    @Override
    public String obterPerfil() {
        return "PROFESSOR";
    }
    
    // ========== IMPLEMENTANDO MÉTODO DA INTERFACE RELATORIO (FASE 6) ==========
    
    /**
     * IMPLEMENTA o método gerarRelatorio() da interface Relatorio
     * Gera um relatório com informações ESPECÍFICAS do professor
     * (POLIMORFISMO - comportamento personalizado)
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       RELATÓRIO DO PROFESSOR           ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("👨‍🏫 DADOS PESSOAIS:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Login: " + login);
        System.out.println("  Perfil: " + obterPerfil());
        System.out.println("\n🎓 DADOS PROFISSIONAIS:");
        System.out.println("  Especialidade: " + especialidade);
        System.out.println("  Registro: " + registro);
        System.out.println("════════════════════════════════════════\n");
    }
    
    // ========== MÉTODOS ESPECÍFICOS DO PROFESSOR ==========
    
    /**
     * Exibe as informações do professor
     */
    public void exibirInfoProfessor() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      INFORMAÇÕES DO PROFESSOR        ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Registro: " + registro);
        System.out.println("Login: " + login);
        System.out.println("Perfil: " + obterPerfil());
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna uma representação em String do Professor
     */
    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", registro='" + registro + '\'' +
                ", perfil='" + obterPerfil() + '\'' +
                '}';
    }
}