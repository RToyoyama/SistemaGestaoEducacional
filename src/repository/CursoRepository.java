package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe CursoRepository
 * Camada REPOSITORY - Responsável por armazenar e gerenciar dados de Cursos
 * RESPONSABILIDADES:
 * - Adicionar curso
 * - Remover curso
 * - Buscar curso por código
 * - Listar todos os cursos
 * - Atualizar curso
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class CursoRepository {
    
    // Lista em memória (temporária) que armazena os cursos
    private List<Curso> cursos;
    
    /**
     * Construtor do CursoRepository
     * Inicializa a lista de cursos
     */
    public CursoRepository() {
        this.cursos = new ArrayList<>();
    }
    
    // ========== MÉTODOS CRUD ==========
    
    /**
     * CREATE - Adiciona um novo curso ao repositório
     * @param curso - Curso a ser adicionado
     * @return true se adicionado com sucesso, false caso contrário
     */
    public boolean adicionar(Curso curso) {
        if (curso == null) {
            System.out.println("❌ Erro: Curso não pode ser nulo!");
            return false;
        }
        
        // Verifica se já existe um curso com esse código
        if (buscarPorCodigo(curso.getCodigo()) != null) {
            System.out.println("❌ Erro: Curso com código " + curso.getCodigo() + " já existe!");
            return false;
        }
        
        cursos.add(curso);
        return true;
    }
    
    /**
     * READ - Busca um curso por código
     * @param codigo - Código do curso
     * @return Objeto Curso se encontrado, null caso contrário
     */
    public Curso buscarPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }
    
    /**
     * READ - Retorna todos os cursos
     * @return Lista de cursos
     */
    public List<Curso> listarTodos() {
        return new ArrayList<>(cursos); // Retorna uma cópia
    }
    
    /**
     * UPDATE - Atualiza um curso existente
     * @param codigo - Código do curso a ser atualizado
     * @param cursoAtualizado - Dados atualizados
     * @return true se atualizado com sucesso, false caso contrário
     */
    public boolean atualizar(String codigo, Curso cursoAtualizado) {
        Curso curso = buscarPorCodigo(codigo);
        
        if (curso == null) {
            System.out.println("❌ Erro: Curso com código " + codigo + " não encontrado!");
            return false;
        }
        
        curso.setNome(cursoAtualizado.getNome());
        curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());
        return true;
    }
    
    /**
     * DELETE - Remove um curso pelo código
     * @param codigo - Código do curso a ser removido
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean remover(String codigo) {
        Curso curso = buscarPorCodigo(codigo);
        
        if (curso == null) {
            System.out.println("❌ Erro: Curso com código " + codigo + " não encontrado!");
            return false;
        }
        
        cursos.remove(curso);
        return true;
    }
    
    /**
     * Retorna a quantidade de cursos armazenados
     * @return Número de cursos
     */
    public int contar() {
        return cursos.size();
    }
    
    /**
     * Limpa todos os cursos do repositório
     */
    public void limpar() {
        cursos.clear();
    }
}