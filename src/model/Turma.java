package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Turma no sistema
 * Responsável por associar um Professor, um Curso e uma lista de Alunos
 * Também gerencia avaliações dos alunos (Fase 3)
 */
public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos;
    private List<Avaliacao> listaAvaliacoes;
    
    /**
     * Construtor da classe Turma
     * @param codigo - Código único da turma (ex: T101)
     * @param professor - Professor que ministra a turma
     * @param curso - Curso oferecido na turma
     */
    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>(); // Inicializa a lista vazia
        this.listaAvaliacoes = new ArrayList<>(); // Inicializa a lista vazia
    }
    
    // ========== GETTERS ==========
    
    public String getCodigo() {
        return codigo;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    
    public List<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }
    
    // ========== SETTERS ==========
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    // ========== MÉTODOS DE GERENCIAMENTO DE ALUNOS ==========
    
    /**
     * Adiciona um aluno à turma
     * @param aluno - Aluno a ser adicionado
     */
    public void adicionarAluno(Aluno aluno) {
        // Verifica se o aluno já existe na turma
        if (aluno == null) {
            System.out.println("❌ Erro: Aluno não pode ser nulo!");
            return;
        }
        
        // Verifica se o aluno já está matriculado
        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                System.out.println("❌ Erro: Aluno " + aluno.getNome() + " já está matriculado nesta turma!");
                return;
            }
        }
        
        // Adiciona o aluno
        listaAlunos.add(aluno);
        System.out.println("✓ Aluno " + aluno.getNome() + " adicionado à turma " + codigo);
    }
    
    /**
     * Remove um aluno da turma pela matrícula
     * @param matricula - Matrícula do aluno a ser removido
     */
    public void removerAluno(String matricula) {
        // Procura o aluno na lista
        Aluno alunoParaRemover = null;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoParaRemover = aluno;
                break;
            }
        }
        
        // Se encontrou, remove
        if (alunoParaRemover != null) {
            listaAlunos.remove(alunoParaRemover);
            System.out.println("✓ Aluno " + alunoParaRemover.getNome() + " removido da turma " + codigo);
        } else {
            System.out.println("❌ Erro: Aluno com matrícula " + matricula + " não encontrado na turma!");
        }
    }
    
    /**
     * Remove um aluno da turma pelo objeto Aluno
     * @param aluno - Aluno a ser removido
     */
    public void removerAluno(Aluno aluno) {
        if (aluno == null) {
            System.out.println("❌ Erro: Aluno não pode ser nulo!");
            return;
        }
        removerAluno(aluno.getMatricula());
    }
    
    /**
     * Retorna a quantidade de alunos na turma
     * @return Número de alunos matriculados
     */
    public int getQuantidadeAlunos() {
        return listaAlunos.size();
    }
    
    // ========== MÉTODOS DE GERENCIAMENTO DE AVALIAÇÕES ==========
    
    /**
     * Adiciona uma avaliação à turma
     * @param avaliacao - Avaliação a ser adicionada
     */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao == null) {
            System.out.println("❌ Erro: Avaliação não pode ser nula!");
            return;
        }
        listaAvaliacoes.add(avaliacao);
        System.out.println("✓ Avaliação de " + avaliacao.getAluno().getNome() + " adicionada à turma!");
    }
    
    /**
     * Obtém todas as avaliações de um aluno específico
     * @param matricula - Matrícula do aluno
     * @return Lista de avaliações do aluno
     */
    public List<Avaliacao> obterAvaliacoesPorAluno(String matricula) {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        for (Avaliacao avaliacao : listaAvaliacoes) {
            if (avaliacao.getAluno().getMatricula().equals(matricula)) {
                avaliacoes.add(avaliacao);
            }
        }
        return avaliacoes;
    }
    
    /**
     * Calcula a média de notas de um aluno
     * @param matricula - Matrícula do aluno
     * @return Média das notas
     */
    public double calcularMediaAluno(String matricula) {
        List<Avaliacao> avaliacoes = obterAvaliacoesPorAluno(matricula);
        
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        
        double soma = 0.0;
        for (Avaliacao av : avaliacoes) {
            soma += av.getNota();
        }
        
        return soma / avaliacoes.size();
    }
    
    /**
     * Exibe um resumo completo da turma
     */
    public void resumoTurma() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          RESUMO DA TURMA               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Código da Turma: " + codigo);
        System.out.println("Professor: " + professor.getNome() + 
                          " (Especialidade: " + professor.getEspecialidade() + ")");
        System.out.println("Curso: " + curso.getNome() + 
                          " (Código: " + curso.getCodigo() + 
                          ", Carga Horária: " + curso.getCargaHoraria() + "h)");
        System.out.println("Quantidade de Alunos: " + getQuantidadeAlunos());
        
        if (getQuantidadeAlunos() > 0) {
            System.out.println("\n--- Alunos Matriculados ---");
            for (int i = 0; i < listaAlunos.size(); i++) {
                Aluno aluno = listaAlunos.get(i);
                System.out.println((i + 1) + ". " + aluno.getNome() + " (" + aluno.getMatricula() + ")");
            }
        } else {
            System.out.println("Nenhum aluno matriculado nesta turma.");
        }
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna uma representação em String da turma
     */
    @Override
    public String toString() {
        return "Turma{" +
                "codigo='" + codigo + '\'' +
                ", professor=" + professor.getNome() +
                ", curso=" + curso.getNome() +
                ", quantidadeAlunos=" + getQuantidadeAlunos() +
                '}';
    }
}