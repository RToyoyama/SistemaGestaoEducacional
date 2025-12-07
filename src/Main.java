import service.*;
import repository.*;
import ui.Menu;

/**
 * Classe Main - FASE FINAL: Sistema Educacional Consolidado
 * 
 * APRESENTAÇÃO PARA INVESTIDORES:
 * O Sistema de Gestão Educacional (SGE) é uma solução completa,
 * profissional e escalável para gerenciar todas as operações de
 * uma instituição educacional.
 * 
 * CARACTERÍSTICAS:
 * ✓ Arquitetura em Camadas (Profissional)
 * ✓ Separação de Responsabilidades (SOLID)
 * ✓ Menu Interativo Completo
 * ✓ Validações Robustas
 * ✓ Relatórios Automáticos
 * ✓ Gestão de Alunos, Professores, Cursos e Turmas
 * ✓ Sistema de Avaliações
 * ✓ Geração de Relatórios Dinâmicos
 * 
 * ESTRUTURA TÉCNICA:
 * ┌──────────────────────────────────────┐
 * │     CAMADA UI (Menu)                 │ ← Interação com usuário
 * ├──────────────────────────────────────┤
 * │  CAMADA SERVICE (Lógica de Negócio)  │ ← Regras de negócio
 * ├──────────────────────────────────────┤
 * │ CAMADA REPOSITORY (Persistência)     │ ← Dados em memória
 * └──────────────────────────────────────┘
 * 
 * (Fase Final: Sistema Educacional Consolidado)
 */
public class Main {
    
    public static void main(String[] args) {
        exibirBemVindo();
        
        // ========== INICIALIZAÇÃO DE CAMADAS ==========
        
        // Camada Repository (Dados)
        AlunoRepository alunoRepository = new AlunoRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();
        CursoRepository cursoRepository = new CursoRepository();
        TurmaRepository turmaRepository = new TurmaRepository();
        
        // Camada Service (Lógica de Negócio)
        AlunoService alunoService = new AlunoService(alunoRepository);
        ProfessorService professorService = new ProfessorService(professorRepository);
        CursoService cursoService = new CursoService(cursoRepository);
        TurmaService turmaService = new TurmaService(turmaRepository);
        SistemaService sistemaService = new SistemaService(alunoService, professorService, 
                                                           cursoService, turmaService);
        
        // Camada UI (Interface)
        Menu menu = new Menu(alunoService, professorService, cursoService, turmaService, sistemaService);
        
        exibirCarregamento();
        
        // Carrega dados de demonstração (opcional)
        sistemaService.inicializarDados();
        
        // Inicia o menu interativo
        menu.iniciar();
        
        exibirEncerramento();
    }
    
    /**
     * Exibe mensagem de boas-vindas
     */
    private static void exibirBemVindo() {
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");
        System.out.println("║  🎓  SISTEMA DE GESTÃO EDUCACIONAL - EDUCONNECT  🎓      ║");
        System.out.println("║                                                          ║");
        System.out.println("║          Solução Profissional para Instituições          ║");
        System.out.println("║               de Educação Moderna                        ║");
        System.out.println("║                                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    /**
     * Exibe mensagem de carregamento
     */
    private static void exibirCarregamento() {
        System.out.println("\n🚀 Inicializando sistema...\n");
        
        try {
            Thread.sleep(500);
            System.out.println("✓ Camada de Persistência (Repository) carregada");
            Thread.sleep(300);
            System.out.println("✓ Camada de Negócio (Service) carregada");
            Thread.sleep(300);
            System.out.println("✓ Camada de Apresentação (UI) carregada");
            Thread.sleep(300);
            System.out.println("✓ Sistema pronto para uso!\n");
        } catch (InterruptedException e) {
            System.out.println("✓ Sistema carregado!");
        }
    }
    
    /**
     * Exibe mensagem de encerramento
     */
    private static void exibirEncerramento() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");
        System.out.println("║        ✓ OBRIGADO POR USAR EDUCONNECT!                   ║");
        System.out.println("║                                                          ║");
        System.out.println("║     Para mais informações, visite: www.educonnect.com    ║");
        System.out.println("║                                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
    }
}