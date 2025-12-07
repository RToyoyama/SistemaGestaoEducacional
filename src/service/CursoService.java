package service;

import model.Curso;
import model.CursoPresencial;
import model.CursoEAD;
import repository.CursoRepository;
import java.util.List;

/**
 * Classe CursoService
 * Camada SERVICE - Responsável por executar a LÓGICA DE NEGÓCIO relacionada a Cursos
 * RESPONSABILIDADES:
 * - Validar dados de curso
 * - Executar regras de negócio
 * - Coordenar com Repository
 * - Criar cursos presenciais e EAD
 * - Gerar relatórios
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class CursoService {
    
    // Dependência do Repository
    private CursoRepository cursoRepository;
    
    /**
     * Construtor do CursoService
     * @param cursoRepository - Repositório de cursos
     */
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    
    /**
     * Cadastra um novo curso presencial
     * @param nome - Nome do curso
     * @param codigo - Código do curso
     * @param cargaHoraria - Carga horária
     * @param salaDeAula - Sala de aula
     * @return true se cadastrado com sucesso, false caso contrário
     */
    public boolean cadastrarCursoPresencial(String nome, String codigo, double cargaHoraria, String salaDeAula) {
        if (!validarDados(nome, codigo, cargaHoraria)) {
            return false;
        }
        
        if (salaDeAula == null || salaDeAula.trim().isEmpty()) {
            System.out.println("❌ Sala de aula não pode estar vazia!");
            return false;
        }
        
        Curso curso = new CursoPresencial(nome, codigo, cargaHoraria, salaDeAula);
        boolean resultado = cursoRepository.adicionar(curso);
        
        if (resultado) {
            System.out.println("✓ Curso Presencial " + nome + " cadastrado com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Cadastra um novo curso EAD
     * @param nome - Nome do curso
     * @param codigo - Código do curso
     * @param cargaHoraria - Carga horária
     * @param plataformaVirtual - Plataforma virtual
     * @return true se cadastrado com sucesso, false caso contrário
     */
    public boolean cadastrarCursoEAD(String nome, String codigo, double cargaHoraria, String plataformaVirtual) {
        if (!validarDados(nome, codigo, cargaHoraria)) {
            return false;
        }
        
        if (plataformaVirtual == null || plataformaVirtual.trim().isEmpty()) {
            System.out.println("❌ Plataforma virtual não pode estar vazia!");
            return false;
        }
        
        Curso curso = new CursoEAD(nome, codigo, cargaHoraria, plataformaVirtual);
        boolean resultado = cursoRepository.adicionar(curso);
        
        if (resultado) {
            System.out.println("✓ Curso EAD " + nome + " cadastrado com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Busca um curso por código
     * @param codigo - Código do curso
     * @return Objeto Curso ou null
     */
    public Curso buscarPorCodigo(String codigo) {
        return cursoRepository.buscarPorCodigo(codigo);
    }
    
    /**
     * Lista todos os cursos
     * @return Lista de cursos
     */
    public List<Curso> listarTodos() {
        return cursoRepository.listarTodos();
    }
    
    /**
     * Remove um curso
     * @param codigo - Código do curso a remover
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean removerCurso(String codigo) {
        Curso curso = cursoRepository.buscarPorCodigo(codigo);
        
        if (curso == null) {
            System.out.println("❌ Curso não encontrado!");
            return false;
        }
        
        boolean resultado = cursoRepository.remover(codigo);
        
        if (resultado) {
            System.out.println("✓ Curso " + curso.getNome() + " removido com sucesso!");
        }
        
        return resultado;
    }
    
    /**
     * Gera um relatório de todos os cursos
     */
    public void gerarRelatorioCursos() {
        List<Curso> cursos = cursoRepository.listarTodos();
        
        if (cursos.isEmpty()) {
            System.out.println("❌ Nenhum curso cadastrado!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      RELATÓRIO DE TODOS OS CURSOS      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total de Cursos: " + cursos.size());
        System.out.println("════════════════════════════════════════\n");
        
        int presenciais = 0;
        int ead = 0;
        
        for (Curso curso : cursos) {
            if (curso instanceof CursoPresencial) {
                presenciais++;
            } else if (curso instanceof CursoEAD) {
                ead++;
            }
            curso.gerarRelatorio();
        }
        
        System.out.println("Resumo: " + presenciais + " Presenciais, " + ead + " EAD\n");
    }
    
    /**
     * Retorna a quantidade de cursos cadastrados
     * @return Número de cursos
     */
    public int contar() {
        return cursoRepository.contar();
    }
    
    // ========== VALIDAÇÕES ==========
    
    /**
     * Valida os dados do curso
     * @return true se válido, false caso contrário
     */
    private boolean validarDados(String nome, String codigo, double cargaHoraria) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("❌ Nome do curso não pode estar vazio!");
            return false;
        }
        
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("❌ Código do curso não pode estar vazio!");
            return false;
        }
        
        if (cargaHoraria <= 0) {
            System.out.println("❌ Carga horária deve ser maior que 0!");
            return false;
        }
        
        return true;
    }
}