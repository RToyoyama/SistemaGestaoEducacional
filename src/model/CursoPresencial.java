package model;

/**
 * Classe que representa um Curso Presencial no sistema
 * HERDA de Curso
 * Adiciona atributo específico: salaDeAula
 * SOBRESCREVE o método detalharCurso() com informações personalizadas
 * (Fase 4: Herança e Polimorfismo)
 */
public class CursoPresencial extends Curso {
    private String salaDeAula;
    
    /**
     * Construtor da classe CursoPresencial
     * @param nome - Nome do curso
     * @param codigo - Código único do curso
     * @param cargaHoraria - Quantidade de horas do curso
     * @param salaDeAula - Número/identificação da sala de aula
     */
    public CursoPresencial(String nome, String codigo, double cargaHoraria, String salaDeAula) {
        // Chama o construtor da classe PAI (Curso)
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }
    
    // ========== GETTERS ==========
    
    public String getSalaDeAula() {
        return salaDeAula;
    }
    
    // ========== SETTERS ==========
    
    public void setSalaDeAula(String salaDeAula) {
        this.salaDeAula = salaDeAula;
    }
    
    // ========== MÉTODOS ==========
    
    /**
     * SOBRESCREVE o método detalharCurso() da classe PAI
     * Exibe informações ESPECÍFICAS de um curso presencial
     * (POLIMORFISMO - comportamento diferente)
     */
    @Override
    public void detalharCurso() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    DETALHES DO CURSO PRESENCIAL      ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        System.out.println("📍 Modalidade: PRESENCIAL");
        System.out.println("🏫 Sala de Aula: " + salaDeAula);
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * SOBRESCREVE o método gerarRelatorio() da interface Relatorio
     * Gera um relatório com informações ESPECÍFICAS do curso presencial
     * (POLIMORFISMO)
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   RELATÓRIO DO CURSO PRESENCIAL        ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("📚 INFORMAÇÕES DO CURSO:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Código: " + codigo);
        System.out.println("  Carga Horária: " + cargaHoraria + " horas");
        System.out.println("\n📍 INFORMAÇÕES PRESENCIAIS:");
        System.out.println("  Modalidade: PRESENCIAL");
        System.out.println("  Sala de Aula: " + salaDeAula);
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna informações sobre a sala de aula
     */
    public void exibirInfoSala() {
        System.out.println("Aula do curso " + nome + " ocorre na sala: " + salaDeAula);
    }
    
    /**
     * Retorna uma representação em String do curso presencial
     */
    @Override
    public String toString() {
        return "CursoPresencial{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", salaDeAula='" + salaDeAula + '\'' +
                ", modalidade='PRESENCIAL'" +
                '}';
    }
}