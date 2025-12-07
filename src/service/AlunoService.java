package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;

/**
 * Classe AlunoService
 * Camada SERVICE - Responsável por executar a LÓGICA DE NEGÓCIO relacionada a Alunos
 * RESPONSABILIDADES:
 * - Validar dados de aluno
 * - Executar regras de negócio
 * - Coordenar com Repository
 * - Gerar relatórios
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class AlunoService {
    
    // Dependência do Repository
    private AlunoRepository alunoRepository;
    
    /**
     * Construtor do AlunoService
     * @param alunoRepository - Repositório de alunos
     */
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    
    /**
     * Cadastra um novo aluno com validações
     * @param nome - Nome do aluno
     * @param login - Login
     * @param senha - Senha
     * @param matricula - Matrícula
     * @param curso - Curso
     * @return true se cadastrado com sucesso, false caso contrário
     */
    public boolean cadastrarAluno(String nome, String login, String senha, String matricula, String curso) {
        // Validações de negócio
        if (!validarDados(nome, login, senha, matricula, curso)) {
            return false;
        }
        
        // Cria o aluno
        Aluno aluno = new Aluno(nome, login, senha, matricula, curso);
        
        // Delega ao repository
        boolean resultado = alunoRepository.adicionar(aluno);
        
        if (resultado) {
            System.out.println("✓ Aluno " + nome + " cadastrado com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Busca um aluno por matrícula
     * @param matricula - Matrícula do aluno
     * @return Objeto Aluno ou null
     */
    public Aluno buscarPorMatricula(String matricula) {
        return alunoRepository.buscarPorMatricula(matricula);
    }
    
    /**
     * Lista todos os alunos
     * @return Lista de alunos
     */
    public List<Aluno> listarTodos() {
        return alunoRepository.listarTodos();
    }
    
    /**
     * Remove um aluno
     * @param matricula - Matrícula do aluno a remover
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean removerAluno(String matricula) {
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
        
        if (aluno == null) {
            System.out.println("❌ Aluno não encontrado!");
            return false;
        }
        
        boolean resultado = alunoRepository.remover(matricula);
        
        if (resultado) {
            System.out.println("✓ Aluno " + aluno.getNome() + " removido com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Gera um relatório de todos os alunos
     */
    public void gerarRelatorioAlunos() {
        List<Aluno> alunos = alunoRepository.listarTodos();
        
        if (alunos.isEmpty()) {
            System.out.println("❌ Nenhum aluno cadastrado!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    RELATÓRIO DE TODOS OS ALUNOS        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total de Alunos: " + alunos.size());
        System.out.println("════════════════════════════════════════\n");
        
        for (Aluno aluno : alunos) {
            aluno.gerarRelatorio();
        }
    }
    
    /**
     * Retorna a quantidade de alunos cadastrados
     * @return Número de alunos
     */
    public int contar() {
        return alunoRepository.contar();
    }
    
    // ========== VALIDAÇÕES ==========
    
    /**
     * Valida os dados do aluno
     * @return true se válido, false caso contrário
     */
    private boolean validarDados(String nome, String login, String senha, String matricula, String curso) {
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
        
        if (matricula == null || matricula.trim().isEmpty()) {
            System.out.println("❌ Matrícula não pode estar vazia!");
            return false;
        }
        
        if (curso == null || curso.trim().isEmpty()) {
            System.out.println("❌ Curso não pode estar vazio!");
            return false;
        }
        
        return true;
    }
}