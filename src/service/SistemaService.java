package service;

/**
 * Classe SistemaService
 * Camada SERVICE - Coordena todos os Services do sistema
 * RESPONSABILIDADES:
 * - Coordenar operações entre diferentes Services
 * - Executar operações complexas que envolvem múltiplas entidades
 * - Gerar relatórios gerais do sistema
 * 
 * (Fase Final: Sistema Consolidado)
 */
public class SistemaService {
    
    private AlunoService alunoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private TurmaService turmaService;
    
    /**
     * Construtor do SistemaService
     * Recebe todas as dependências dos Services
     */
    public SistemaService(AlunoService alunoService, ProfessorService professorService,
                         CursoService cursoService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
    }
    
    // ========== MÉTODOS DE COORDENAÇÃO ==========
    
    /**
     * Gera um relatório completo do sistema
     */
    public void gerarRelatorioCompleto() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║       RELATÓRIO COMPLETO DO SISTEMA EDUCACIONAL          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        // Exibe estatísticas gerais
        int totalAlunos = alunoService.contar();
        int totalProfessores = professorService.contar();
        int totalCursos = cursoService.contar();
        int totalTurmas = turmaService.contar();
        
        System.out.println("📊 ESTATÍSTICAS GERAIS:");
        System.out.println("  👥 Total de Alunos: " + totalAlunos);
        System.out.println("  👨‍🏫 Total de Professores: " + totalProfessores);
        System.out.println("  📚 Total de Cursos: " + totalCursos);
        System.out.println("  📖 Total de Turmas: " + totalTurmas);
        System.out.println("════════════════════════════════════════════════════════════\n");
        
        // Gera relatórios por tipo
        if (totalAlunos > 0) {
            alunoService.gerarRelatorioAlunos();
        }
        
        if (totalProfessores > 0) {
            professorService.gerarRelatorioProfessores();
        }
        
        if (totalCursos > 0) {
            cursoService.gerarRelatorioCursos();
        }
        
        if (totalTurmas > 0) {
            turmaService.gerarRelatorioTurmas();
        }
    }
    
    /**
     * Exibe um resumo rápido do sistema
     */
    public void exibirResumoSistema() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      RESUMO DO SISTEMA                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("👥 Alunos: " + alunoService.contar());
        System.out.println("👨‍🏫 Professores: " + professorService.contar());
        System.out.println("📚 Cursos: " + cursoService.contar());
        System.out.println("📖 Turmas: " + turmaService.contar());
        System.out.println("════════════════════════════════════════\n");
    }
    
    /**
     * Inicializa o sistema com dados de demonstração
     */
    public void inicializarDados() {
        System.out.println("\n📥 Carregando dados de demonstração...\n");
        
        // Alunos
        alunoService.cadastrarAluno("João Silva", "joao", "123", "2024001", "Engenharia");
        alunoService.cadastrarAluno("Maria Santos", "maria", "456", "2024002", "Engenharia");
        alunoService.cadastrarAluno("Pedro Costa", "pedro", "789", "2024003", "Sistemas");
        
        // Professores
        professorService.cadastrarProfessor("Dr. Carlos", "carlos", "pass1", "Programação", "REG001");
        professorService.cadastrarProfessor("Dra. Ana", "ana", "pass2", "BD", "REG002");
        
        // Cursos
        cursoService.cadastrarCursoPresencial("Java", "CS101", 80, "Sala 405");
        cursoService.cadastrarCursoEAD("Python", "CS102", 60, "Google Classroom");
        
        System.out.println("✓ Dados carregados com sucesso!\n");
    }
}