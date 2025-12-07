package model;

/**
 * Classe que representa um Aluno no sistema
 * HERDA de Usuario (classe abstrata)
 * IMPLEMENTA Autenticavel (interface)
 * IMPLEMENTA Relatorio (interface) - Fase 6
 * 
 * (Fase 5: Interfaces e Abstração)
 * (Fase 6: Relatórios e Polimorfismo)
 */
public class Aluno extends Usuario {
    private String matricula;
    private String curso;
    
    /**
     * Construtor da classe Aluno
     * @param nome - Nome do aluno
     * @param login - Login para autenticação
     * @param senha - Senha para autenticação
     * @param matricula - Número de matrícula único
     * @param curso - Nome do curso em que está matriculado
     */
    public Aluno(String nome, String login, String senha, String matricula, String curso) {
        // Chama o construtor da classe PAI (Usuario)
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }
    
    // ========== GETTERS ==========
    
    public String getMatricula() {
        return matricula;
    }
    
    public String getCurso() {
        return curso;
    }
    
    // ========== SETTERS ==========
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    // ========== IMPLEMENTANDO MÉTODOS DA INTERFACE AUTENTICAVEL ==========
    
    /**
     * IMPLEMENTA o método autenticar() da interface Autenticavel
     * Valida as credenciais do aluno
     * 
     * @param login - Login fornecido
     * @param senha - Senha fornecida
     * @return true se login E senha estão corretos, false caso contrário
     */
    @Override
    public boolean autenticar(String login, String senha) {
        // Verifica se o login corresponde
        if (!this.login.equals(login)) {
            System.out.println("❌ Login inválido para aluno!");
            return false;
        }
        
        // Verifica se a senha corresponde
        if (!this.senha.equals(senha)) {
            System.out.println("❌ Senha incorreta!");
            return false;
        }
        
        // Se chegou aqui, credenciais estão corretas
        System.out.println("✓ Aluno " + nome + " autenticado com sucesso!");
        return true;
    }
    
    /**
     * IMPLEMENTA o método abstrato obterPerfil() da classe Usuario
     * 
     * @return String com o perfil do usuário
     */
    @Override
    public String obterPerfil() {
        return "ALUNO";
    }
    
    // ========== IMPLEMENTANDO MÉTODO DA INTERFACE RELATORIO (FASE 6) ==========
    
    /**
     * IMPLEMENTA o método gerarRelatorio() da interface Relatorio
     * Gera um relatório com informações ESPECÍFICAS do aluno
     * (POLIMORFISMO - comportamento personalizado)
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        RELATÓRIO DO ALUNO              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("📊 DADOS PESSOAIS:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Login: " + login);
        System.out.println("  Perfil: " + obterPerfil());
        System.out.println("\n📚 DADOS ACADÊMICOS:");
        System.out.println("  Matrícula: " + matricula);
        System.out.println("  Curso: " + curso);
        System.out.println("════════════════════════════════════════\n");
    }
    
    // ========== MÉTODOS ESPECÍFICOS DO ALUNO ==========
    
    /**
     * Exibe as informações do aluno
     */
    public void exibirInfoAluno() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       INFORMAÇÕES DO ALUNO           ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Login: " + login);
        System.out.println("Perfil: " + obterPerfil());
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna uma representação em String do Aluno
     */
    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                ", perfil='" + obterPerfil() + '\'' +
                '}';
    }
}