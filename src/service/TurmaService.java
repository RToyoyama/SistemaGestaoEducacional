package service;

import model.Turma;
import model.Professor;
import model.Curso;
import repository.TurmaRepository;
import java.util.List;

/**
 * Classe TurmaService
 * Camada SERVICE - Responsável por executar a LÓGICA DE NEGÓCIO relacionada a Turmas
 * RESPONSABILIDADES:
 * - Validar dados de turma
 * - Executar regras de negócio
 * - Coordenar com Repository
 * - Gerar relatórios
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class TurmaService {
    
    // Dependência do Repository
    private TurmaRepository turmaRepository;
    
    /**
     * Construtor do TurmaService
     * @param turmaRepository - Repositório de turmas
     */
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    
    /**
     * Cadastra uma nova turma com validações
     * @param codigo - Código da turma
     * @param professor - Professor da turma
     * @param curso - Curso da turma
     * @return true se cadastrada com sucesso, false caso contrário
     */
    public boolean cadastrarTurma(String codigo, Professor professor, Curso curso) {
        // Validações de negócio
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("❌ Código da turma não pode estar vazio!");
            return false;
        }
        
        if (professor == null) {
            System.out.println("❌ Professor não pode ser nulo!");
            return false;
        }
        
        if (curso == null) {
            System.out.println("❌ Curso não pode ser nulo!");
            return false;
        }
        
        // Cria a turma
        Turma turma = new Turma(codigo, professor, curso);
        
        // Delega ao repository
        boolean resultado = turmaRepository.adicionar(turma);
        
        if (resultado) {
            System.out.println("✓ Turma " + codigo + " cadastrada com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Busca uma turma por código
     * @param codigo - Código da turma
     * @return Objeto Turma ou null
     */
    public Turma buscarPorCodigo(String codigo) {
        return turmaRepository.buscarPorCodigo(codigo);
    }
    
    /**
     * Lista todas as turmas
     * @return Lista de turmas
     */
    public List<Turma> listarTodas() {
        return turmaRepository.listarTodas();
    }
    
    /**
     * Remove uma turma
     * @param codigo - Código da turma a remover
     * @return true se removida com sucesso, false caso contrário
     */
    public boolean removerTurma(String codigo) {
        Turma turma = turmaRepository.buscarPorCodigo(codigo);
        
        if (turma == null) {
            System.out.println("❌ Turma não encontrada!");
            return false;
        }
        
        boolean resultado = turmaRepository.remover(codigo);
        
        if (resultado) {
            System.out.println("✓ Turma " + turma.getCodigo() + " removida com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Gera um relatório de todas as turmas
     */
    public void gerarRelatorioTurmas() {
        List<Turma> turmas = turmaRepository.listarTodas();
        
        if (turmas.isEmpty()) {
            System.out.println("❌ Nenhuma turma cadastrada!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      RELATÓRIO DE TODAS AS TURMAS      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total de Turmas: " + turmas.size());
        System.out.println("════════════════════════════════════════\n");
        
        for (Turma turma : turmas) {
            turma.resumoTurma();
        }
    }
    
    /**
     * Retorna a quantidade de turmas cadastradas
     * @return Número de turmas
     */
    public int contar() {
        return turmaRepository.contar();
    }
}