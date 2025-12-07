package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe TurmaRepository
 * Camada REPOSITORY - Responsável por armazenar e gerenciar dados de Turmas
 * RESPONSABILIDADES:
 * - Adicionar turma
 * - Remover turma
 * - Buscar turma por código
 * - Listar todas as turmas
 * - Atualizar turma
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class TurmaRepository {
    
    // Lista em memória (temporária) que armazena as turmas
    private List<Turma> turmas;
    
    /**
     * Construtor do TurmaRepository
     * Inicializa a lista de turmas
     */
    public TurmaRepository() {
        this.turmas = new ArrayList<>();
    }
    
    // ========== MÉTODOS CRUD ==========
    
    /**
     * CREATE - Adiciona uma nova turma ao repositório
     * @param turma - Turma a ser adicionada
     * @return true se adicionada com sucesso, false caso contrário
     */
    public boolean adicionar(Turma turma) {
        if (turma == null) {
            System.out.println("❌ Erro: Turma não pode ser nula!");
            return false;
        }
        
        // Verifica se já existe uma turma com esse código
        if (buscarPorCodigo(turma.getCodigo()) != null) {
            System.out.println("❌ Erro: Turma com código " + turma.getCodigo() + " já existe!");
            return false;
        }
        
        turmas.add(turma);
        return true;
    }
    
    /**
     * READ - Busca uma turma por código
     * @param codigo - Código da turma
     * @return Objeto Turma se encontrado, null caso contrário
     */
    public Turma buscarPorCodigo(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }
    
    /**
     * READ - Retorna todas as turmas
     * @return Lista de turmas
     */
    public List<Turma> listarTodas() {
        return new ArrayList<>(turmas); // Retorna uma cópia
    }
    
    /**
     * UPDATE - Atualiza uma turma existente
     * @param codigo - Código da turma a ser atualizada
     * @param turmaAtualizada - Dados atualizados
     * @return true se atualizada com sucesso, false caso contrário
     */
    public boolean atualizar(String codigo, Turma turmaAtualizada) {
        Turma turma = buscarPorCodigo(codigo);
        
        if (turma == null) {
            System.out.println("❌ Erro: Turma com código " + codigo + " não encontrada!");
            return false;
        }
        
        turma.setCodigo(turmaAtualizada.getCodigo());
        turma.setProfessor(turmaAtualizada.getProfessor());
        turma.setCurso(turmaAtualizada.getCurso());
        return true;
    }
    
    /**
     * DELETE - Remove uma turma pelo código
     * @param codigo - Código da turma a ser removida
     * @return true se removida com sucesso, false caso contrário
     */
    public boolean remover(String codigo) {
        Turma turma = buscarPorCodigo(codigo);
        
        if (turma == null) {
            System.out.println("❌ Erro: Turma com código " + codigo + " não encontrada!");
            return false;
        }
        
        turmas.remove(turma);
        return true;
    }
    
    /**
     * Retorna a quantidade de turmas armazenadas
     * @return Número de turmas
     */
    public int contar() {
        return turmas.size();
    }
    
    /**
     * Limpa todas as turmas do repositório
     */
    public void limpar() {
        turmas.clear();
    }
}