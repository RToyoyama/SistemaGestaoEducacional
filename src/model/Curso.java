package model;

/**
 * Classe que representa um Curso no sistema
 * CLASSE BASE para CursoPresencial e CursoEAD
 * IMPLEMENTA Relatorio (interface) - Fase 6
 * Responsável por armazenar informações básicas do curso
 * (Fase 4: Herança e Polimorfismo)
 * (Fase 6: Relatórios e Polimorfismo)
 */
public class Curso implements Relatorio {
    protected String nome;
    protected String codigo;
    protected double cargaHoraria;
    
    /**
     * Construtor da classe Curso
     * @param nome - Nome do curso
     * @param codigo - Código único do curso (ex: CS101)
     * @param cargaHoraria - Quantidade de horas do curso
     */
    public Curso(String nome, String codigo, double cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }
    
    // ========== GETTERS ==========
    
    public String getNome() {
        return nome;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public double getCargaHoraria() {
        return cargaHoraria;
    }
    
    // ========== SETTERS ==========
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    // ========== MÉTODOS ==========
    
    /**
     * Método que será SOBRESCRITO pelas subclasses
     * Cada tipo de curso terá sua forma própria de detalhar
     * (POLIMORFISMO)
     */
    public void detalharCurso() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       DETALHES DO CURSO              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        System.out.println("════════════════════════════════════════\n");
    }
    
    // ========== IMPLEMENTANDO MÉTODO DA INTERFACE RELATORIO (FASE 6) ==========
    
    /**
     * IMPLEMENTA o método gerarRelatorio() da interface Relatorio
     * Gera um relatório com informações do curso
     * (POLIMORFISMO - comportamento personalizado em subclasses)
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        RELATÓRIO DO CURSO              ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("📖 INFORMAÇÕES DO CURSO:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Código: " + codigo);
        System.out.println("  Carga Horária: " + cargaHoraria + " horas");
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna uma representação em String da classe Curso
     */
    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}