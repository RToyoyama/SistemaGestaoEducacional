package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe AlunoRepository
 * Camada REPOSITORY - Responsável por armazenar e gerenciar dados de Alunos
 * RESPONSABILIDADES:
 * - Adicionar aluno
 * - Remover aluno
 * - Buscar aluno por matrícula
 * - Listar todos os alunos
 * - Atualizar aluno
 * 
 * (Fase 7: Arquitetura em Camadas)
 */
public class AlunoRepository {
    
    // Lista em memória (temporária) que armazena os alunos
    private List<Aluno> alunos;
    
    /**
     * Construtor do AlunoRepository
     * Inicializa a lista de alunos
     */
    public AlunoRepository() {
        this.alunos = new ArrayList<>();
    }
    
    // ========== MÉTODOS CRUD ==========
    
    /**
     * CREATE - Adiciona um novo aluno ao repositório
     * @param aluno - Aluno a ser adicionado
     * @return true se adicionado com sucesso, false caso contrário
     */
    public boolean adicionar(Aluno aluno) {
        if (aluno == null) {
            System.out.println("❌ Erro: Aluno não pode ser nulo!");
            return false;
        }
        
        // Verifica se já existe um aluno com essa matrícula
        if (buscarPorMatricula(aluno.getMatricula()) != null) {
            System.out.println("❌ Erro: Aluno com matrícula " + aluno.getMatricula() + " já existe!");
            return false;
        }
        
        alunos.add(aluno);
        return true;
    }
    
    /**
     * READ - Busca um aluno por matrícula
     * @param matricula - Matrícula do aluno
     * @return Objeto Aluno se encontrado, null caso contrário
     */
    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }
    
    /**
     * READ - Retorna todos os alunos
     * @return Lista de alunos
     */
    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos); // Retorna uma cópia
    }
    
    /**
     * UPDATE - Atualiza um aluno existente
     * @param matricula - Matrícula do aluno a ser atualizado
     * @param alunoAtualizado - Dados atualizados
     * @return true se atualizado com sucesso, false caso contrário
     */
    public boolean atualizar(String matricula, Aluno alunoAtualizado) {
        Aluno aluno = buscarPorMatricula(matricula);
        
        if (aluno == null) {
            System.out.println("❌ Erro: Aluno com matrícula " + matricula + " não encontrado!");
            return false;
        }
        
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setCurso(alunoAtualizado.getCurso());
        aluno.setLogin(alunoAtualizado.getLogin());
        aluno.setSenha(alunoAtualizado.getSenha());
        return true;
    }
    
    /**
     * DELETE - Remove um aluno pelo matrícula
     * @param matricula - Matrícula do aluno a ser removido
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean remover(String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        
        if (aluno == null) {
            System.out.println("❌ Erro: Aluno com matrícula " + matricula + " não encontrado!");
            return false;
        }
        
        alunos.remove(aluno);
        return true;
    }
    
    /**
     * Retorna a quantidade de alunos armazenados
     * @return Número de alunos
     */
    public int contar() {
        return alunos.size();
    }
    
    /**
     * Limpa todos os alunos do repositório
     */
    public void limpar() {
        alunos.clear();
    }
}