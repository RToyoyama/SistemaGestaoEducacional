package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe ProfessorRepository
 * Camada REPOSITORY - Responsável por armazenar e gerenciar dados de Professores
 * RESPONSABILIDADES:
 * - Adicionar professor
 * - Remover professor
 * - Buscar professor por registro
 * - Listar todos os professores
 * - Atualizar professor
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class ProfessorRepository {
    
    // Lista em memória (temporária) que armazena os professores
    private List<Professor> professores;
    
    /**
     * Construtor do ProfessorRepository
     * Inicializa a lista de professores
     */
    public ProfessorRepository() {
        this.professores = new ArrayList<>();
    }
    
    // ========== MÉTODOS CRUD ==========
    
    /**
     * CREATE - Adiciona um novo professor ao repositório
     * @param professor - Professor a ser adicionado
     * @return true se adicionado com sucesso, false caso contrário
     */
    public boolean adicionar(Professor professor) {
        if (professor == null) {
            System.out.println("❌ Erro: Professor não pode ser nulo!");
            return false;
        }
        
        // Verifica se já existe um professor com esse registro
        if (buscarPorRegistro(professor.getRegistro()) != null) {
            System.out.println("❌ Erro: Professor com registro " + professor.getRegistro() + " já existe!");
            return false;
        }
        
        professores.add(professor);
        return true;
    }
    
    /**
     * READ - Busca um professor por registro
     * @param registro - Registro do professor
     * @return Objeto Professor se encontrado, null caso contrário
     */
    public Professor buscarPorRegistro(String registro) {
        for (Professor professor : professores) {
            if (professor.getRegistro().equals(registro)) {
                return professor;
            }
        }
        return null;
    }
    
    /**
     * READ - Retorna todos os professores
     * @return Lista de professores
     */
    public List<Professor> listarTodos() {
        return new ArrayList<>(professores); // Retorna uma cópia
    }
    
    /**
     * UPDATE - Atualiza um professor existente
     * @param registro - Registro do professor a ser atualizado
     * @param professorAtualizado - Dados atualizados
     * @return true se atualizado com sucesso, false caso contrário
     */
    public boolean atualizar(String registro, Professor professorAtualizado) {
        Professor professor = buscarPorRegistro(registro);
        
        if (professor == null) {
            System.out.println("❌ Erro: Professor com registro " + registro + " não encontrado!");
            return false;
        }
        
        professor.setNome(professorAtualizado.getNome());
        professor.setEspecialidade(professorAtualizado.getEspecialidade());
        professor.setLogin(professorAtualizado.getLogin());
        professor.setSenha(professorAtualizado.getSenha());
        return true;
    }
    
    /**
     * DELETE - Remove um professor pelo registro
     * @param registro - Registro do professor a ser removido
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean remover(String registro) {
        Professor professor = buscarPorRegistro(registro);
        
        if (professor == null) {
            System.out.println("❌ Erro: Professor com registro " + registro + " não encontrado!");
            return false;
        }
        
        professores.remove(professor);
        return true;
    }
    
    /**
     * Retorna a quantidade de professores armazenados
     * @return Número de professores
     */
    public int contar() {
        return professores.size();
    }
    
    /**
     * Limpa todos os professores do repositório
     */
    public void limpar() {
        professores.clear();
    }
}