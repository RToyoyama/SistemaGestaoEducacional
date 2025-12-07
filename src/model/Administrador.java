package model;

/**
 * Classe que representa um Administrador no sistema
 * HERDA de Usuario (classe abstrata)
 * IMPLEMENTA Autenticavel (interface)
 * 
 * Administrador tem permissões especiais no sistema
 * (Fase 5: Interfaces e Abstração)
 */
public class Administrador extends Usuario {
    private String departamento;
    private String nivelAcesso; // BAIXO, MÉDIO, ALTO
    
    /**
     * Construtor da classe Administrador
     * @param nome - Nome do administrador
     * @param login - Login para autenticação
     * @param senha - Senha para autenticação
     * @param departamento - Departamento ao qual pertence
     * @param nivelAcesso - Nível de acesso (BAIXO, MÉDIO, ALTO)
     */
    public Administrador(String nome, String login, String senha, String departamento, String nivelAcesso) {
        // Chama o construtor da classe PAI (Usuario)
        super(nome, login, senha);
        this.departamento = departamento;
        this.nivelAcesso = nivelAcesso;
    }
    
    // ========== GETTERS ==========
    
    public String getDepartamento() {
        return departamento;
    }
    
    public String getNivelAcesso() {
        return nivelAcesso;
    }
    
    // ========== SETTERS ==========
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    // ========== IMPLEMENTANDO MÉTODOS DA INTERFACE AUTENTICAVEL ==========
    
    /**
     * IMPLEMENTA o método autenticar() da interface Autenticavel
     * Valida as credenciais do administrador
     * Administrador tem validação mais rigorosa
     * 
     * @param login - Login fornecido
     * @param senha - Senha fornecida
     * @return true se login E senha estão corretos, false caso contrário
     */
    @Override
    public boolean autenticar(String login, String senha) {
        // Verifica se o login é nulo ou vazio
        if (login == null || login.isEmpty()) {
            System.out.println("❌ Login não pode ser vazio!");
            return false;
        }
        
        // Verifica se a senha é nulo ou vazio
        if (senha == null || senha.isEmpty()) {
            System.out.println("❌ Senha não pode ser vazia!");
            return false;
        }
        
        // Verifica se o login corresponde
        if (!this.login.equals(login)) {
            System.out.println("❌ Login inválido para administrador!");
            return false;
        }
        
        // Verifica se a senha corresponde
        if (!this.senha.equals(senha)) {
            System.out.println("❌ Senha incorreta!");
            return false;
        }
        
        // Se chegou aqui, credenciais estão corretas
        System.out.println("✓ Administrador " + nome + " autenticado com sucesso!");
        System.out.println("  Nível de acesso: " + nivelAcesso);
        return true;
    }
    
    /**
     * IMPLEMENTA o método abstrato obterPerfil() da classe Usuario
     * 
     * @return String com o perfil do usuário
     */
    @Override
    public String obterPerfil() {
        return "ADMINISTRADOR";
    }
    
    // ========== IMPLEMENTANDO MÉTODO DA INTERFACE RELATORIO (FASE 6) ==========
    
    /**
     * IMPLEMENTA o método gerarRelatorio() da interface Relatorio
     * Gera um relatório com informações ESPECÍFICAS do administrador
     * (POLIMORFISMO - comportamento personalizado)
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    RELATÓRIO DO ADMINISTRADOR          ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("🔐 DADOS DE ACESSO:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Login: " + login);
        System.out.println("  Perfil: " + obterPerfil());
        System.out.println("\n🏢 DADOS ADMINISTRATIVOS:");
        System.out.println("  Departamento: " + departamento);
        System.out.println("  Nível de Acesso: " + nivelAcesso);
        System.out.println("════════════════════════════════════════\n");
    }
    
    // ========== MÉTODOS ESPECÍFICOS DO ADMINISTRADOR ==========
    
    /**
     * Verifica se o administrador tem permissão para uma ação
     * @param acao - Ação a ser realizada
     * @return true se tem permissão, false caso contrário
     */
    public boolean temPermissao(String acao) {
        if ("ALTO".equals(nivelAcesso)) {
            return true; // Administrador com nível ALTO tem todas as permissões
        } else if ("MÉDIO".equals(nivelAcesso)) {
            // Administrador com nível MÉDIO tem permissões limitadas
            return !acao.equals("deletar_usuario") && !acao.equals("resetar_sistema");
        } else {
            // Administrador com nível BAIXO tem permissões muito limitadas
            return acao.equals("visualizar_relatorio") || acao.equals("consultar_dados");
        }
    }
    
    /**
     * Exibe as informações do administrador
     */
    public void exibirInfoAdministrador() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    INFORMAÇÕES DO ADMINISTRADOR      ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento);
        System.out.println("Nível de Acesso: " + nivelAcesso);
        System.out.println("Login: " + login);
        System.out.println("Perfil: " + obterPerfil());
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna uma representação em String do Administrador
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", departamento='" + departamento + '\'' +
                ", nivelAcesso='" + nivelAcesso + '\'' +
                ", perfil='" + obterPerfil() + '\'' +
                '}';
    }
}