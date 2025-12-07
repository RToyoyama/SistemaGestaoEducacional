package model;

/**
 * Classe que representa um Curso EAD (Educação a Distância) no sistema
 * HERDA de Curso
 * Adiciona atributo específico: plataformaVirtual
 * SOBRESCREVE o método detalharCurso() com informações personalizadas
 * (Fase 4: Herança e Polimorfismo)
 */
public class CursoEAD extends Curso {
    private String plataformaVirtual;
    
    /**
     * Construtor da classe CursoEAD
     * @param nome - Nome do curso
     * @param codigo - Código único do curso
     * @param cargaHoraria - Quantidade de horas do curso
     * @param plataformaVirtual - Nome da plataforma virtual (ex: Moodle, Teams, Zoom)
     */
    public CursoEAD(String nome, String codigo, double cargaHoraria, String plataformaVirtual) {
        // Chama o construtor da classe PAI (Curso)
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }
    
    // ========== GETTERS ==========
    
    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }
    
    // ========== SETTERS ==========
    
    public void setPlataformaVirtual(String plataformaVirtual) {
        this.plataformaVirtual = plataformaVirtual;
    }
    
    // ========== MÉTODOS ==========
    
    /**
     * SOBRESCREVE o método detalharCurso() da classe PAI
     * Exibe informações ESPECÍFICAS de um curso EAD
     * (POLIMORFISMO - comportamento diferente)
     */
    @Override
    public void detalharCurso() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      DETALHES DO CURSO EAD           ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        System.out.println("📡 Modalidade: EAD (Educação a Distância)");
        System.out.println("💻 Plataforma Virtual: " + plataformaVirtual);
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * SOBRESCREVE o método gerarRelatorio() da interface Relatorio
     * Gera um relatório com informações ESPECÍFICAS do curso EAD
     * (POLIMORFISMO)
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      RELATÓRIO DO CURSO EAD            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("📚 INFORMAÇÕES DO CURSO:");
        System.out.println("  Nome: " + nome);
        System.out.println("  Código: " + codigo);
        System.out.println("  Carga Horária: " + cargaHoraria + " horas");
        System.out.println("\n📡 INFORMAÇÕES EAD:");
        System.out.println("  Modalidade: EAD (Educação a Distância)");
        System.out.println("  Plataforma Virtual: " + plataformaVirtual);
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Retorna informações sobre a plataforma virtual
     */
    public void exibirInfoPlataforma() {
        System.out.println("Curso " + nome + " é ministrado via: " + plataformaVirtual);
    }
    
    /**
     * Retorna uma representação em String do curso EAD
     */
    @Override
    public String toString() {
        return "CursoEAD{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", plataformaVirtual='" + plataformaVirtual + '\'' +
                ", modalidade='EAD'" +
                '}';
    }
}