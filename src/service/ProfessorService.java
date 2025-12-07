package service;

import model.Professor;
import repository.ProfessorRepository;
import java.util.List;

/**
 * Classe ProfessorService
 * Camada SERVICE - Responsável por executar a LÓGICA DE NEGÓCIO relacionada a Professores
 * RESPONSABILIDADES:
 * - Validar dados de professor
 * - Executar regras de negócio
 * - Coordenar com Repository
 * - Gerar relatórios
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class ProfessorService {
    
    // Dependência do Repository
    private ProfessorRepository professorRepository;
    
    /**
     * Construtor do ProfessorService
     * @param professorRepository - Repositório de professores
     */
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    
    /**
     * Cadastra um novo professor com validações
     * @param nome - Nome do professor
     * @param login - Login
     * @param senha - Senha
     * @param especialidade - Especialidade
     * @param registro - Registro
     * @return true se cadastrado com sucesso, false caso contrário
     */
    public boolean cadastrarProfessor(String nome, String login, String senha, String especialidade, String registro) {
        // Validações de negócio
        if (!validarDados(nome, login, senha, especialidade, registro)) {
            return false;
        }
        
        // Cria o professor
        Professor professor = new Professor(nome, login, senha, especialidade, registro);
        
        // Delega ao repository
        boolean resultado = professorRepository.adicionar(professor);
        
        if (resultado) {
            System.out.println("✓ Professor " + nome + " cadastrado com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Busca um professor por registro
     * @param registro - Registro do professor
     * @return Objeto Professor ou null
     */
    public Professor buscarPorRegistro(String registro) {
        return professorRepository.buscarPorRegistro(registro);
    }
    
    /**
     * Lista todos os professores
     * @return Lista de professores
     */
    public List<Professor> listarTodos() {
        return professorRepository.listarTodos();
    }
    
    /**
     * Remove um professor
     * @param registro - Registro do professor a remover
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean removerProfessor(String registro) {
        Professor professor = professorRepository.buscarPorRegistro(registro);
        
        if (professor == null) {
            System.out.println("❌ Professor não encontrado!");
            return false;
        }
        
        boolean resultado = professorRepository.remover(registro);
        
        if (resultado) {
            System.out.println("✓ Professor " + professor.getNome() + " removido com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Gera um relatório de todos os professores
     */
    public void gerarRelatorioProfessores() {
        List<Professor> professores = professorRepository.listarTodos();
        
        if (professores.isEmpty()) {
            System.out.println("❌ Nenhum professor cadastrado!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   RELATÓRIO DE TODOS OS PROFESSORES    ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total de Professores: " + professores.size());
        System.out.println("════════════════════════════════════════\n");
        
        for (Professor professor : professores) {
            professor.gerarRelatorio();
        }
    }
    
    /**
     * Retorna a quantidade de professores cadastrados
     * @return Número de professores
     */
    public int contar() {
        return professorRepository.contar();
    }
    
    // ========== VALIDAÇÕES ==========
    
    /**
     * Valida os dados do professor
     * @return true se válido, false caso contrário
     */
    private boolean validarDados(String nome, String login, String senha, String especialidade, String registro) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("❌ Nome não pode estar vazio!");
            return false;
        }
        
        if (login == null || login.trim().isEmpty()) {
            System.out.println("❌ Login não pode estar vazio!");
            return false;
        }
        
        if (senha == null || senha.trim().isEmpty()) {
            System.out.println("❌ Senha não pode estar vazia!");
            return false;
        }
        
        if (especialidade == null || especialidade.trim().isEmpty()) {
            System.out.println("❌ Especialidade não pode estar vazia!");
            return false;
        }
        
        if (registro == null || registro.trim().isEmpty()) {
            System.out.println("❌ Registro não pode estar vazio!");
            return false;
        }
        
        return true;
    }
}