package model;

/**
 * Classe que representa uma Avaliação no sistema
 * Responsável por armazenar notas e descrições de avaliações
 * Utiliza ENCAPSULAMENTO para garantir segurança no acesso às notas
 */
public class Avaliacao {
    // ========== ATRIBUTOS PRIVADOS ==========
    private double nota;
    private String descricao;
    private Aluno aluno;
    
    // Constante para validação
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    
    /**
     * Construtor da classe Avaliacao
     * @param descricao - Descrição da avaliação (ex: "Prova 1", "Trabalho Final")
     * @param aluno - Aluno que realizou a avaliação
     */
    public Avaliacao(String descricao, Aluno aluno) {
        this.descricao = descricao;
        this.aluno = aluno;
        this.nota = 0.0; // Inicializa com 0
    }
    
    // ========== GETTERS (APENAS LEITURA) ==========
    
    /**
     * Retorna a nota da avaliação
     * @return Valor da nota
     */
    public double getNota() {
        return nota;
    }
    
    /**
     * Retorna a descrição da avaliação
     * @return Descrição
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Retorna o aluno avaliado
     * @return Objeto Aluno
     */
    public Aluno getAluno() {
        return aluno;
    }
    
    // ========== NÃO TEMOS SETTERS DIRETOS ==========
    // A nota SÓ pode ser alterada através do método atribuirNota()
    // que valida o valor antes de atribuir
    
    // ========== MÉTODOS DE NEGÓCIO ==========
    
    /**
     * Atribui uma nota à avaliação com validação
     * VALIDAÇÕES:
     * - Nota deve ser >= 0
     * - Nota deve ser <= 10
     * - Rejeita valores inválidos com mensagem de erro
     * 
     * @param valor - Valor da nota a ser atribuída
     * @return true se a nota foi atribuída com sucesso, false caso contrário
     */
    public boolean atribuirNota(double valor) {
        // Validação 1: Verificar se a nota é menor que o mínimo
        if (valor < NOTA_MINIMA) {
            System.out.println("❌ ERRO: Nota não pode ser menor que " + NOTA_MINIMA);
            System.out.println("   Você tentou atribuir: " + valor);
            return false;
        }
        
        // Validação 2: Verificar se a nota é maior que o máximo
        if (valor > NOTA_MAXIMA) {
            System.out.println("❌ ERRO: Nota não pode ser maior que " + NOTA_MAXIMA);
            System.out.println("   Você tentou atribuir: " + valor);
            return false;
        }
        
        // Se passou em todas as validações, atribui a nota
        this.nota = valor;
        System.out.println("✓ Nota " + valor + " atribuída com sucesso para " + aluno.getNome());
        return true;
    }
    
    /**
     * Retorna a situação do aluno com base na nota
     * @return String com a situação (Aprovado, Recuperação, Reprovado)
     */
    public String obterSituacao() {
        if (nota >= 7.0) {
            return "Aprovado";
        } else if (nota >= 5.0) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }
    
    /**
     * Retorna uma representação detalhada da avaliação
     */
    public void exibirDetalhes() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       DETALHES DA AVALIAÇÃO          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Matrícula: " + aluno.getMatricula());
        System.out.println("Descrição: " + descricao);
        System.out.println("Nota: " + nota);
        System.out.println("Situação: " + obterSituacao());
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna uma representação em String da avaliação
     */
    @Override
    public String toString() {
        return "Avaliacao{" +
                "aluno='" + aluno.getNome() + '\'' +
                ", descricao='" + descricao + '\'' +
                ", nota=" + nota +
                ", situacao='" + obterSituacao() + '\'' +
                '}';
    }
}