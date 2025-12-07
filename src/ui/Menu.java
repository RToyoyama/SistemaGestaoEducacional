package ui;

import service.*;
import model.*;
import java.util.Scanner;
import java.util.List;

/**
 * Classe Menu
 * Camada UI - VERSÃO COMPLETA COM INTERATIVIDADE TOTAL
 * RESPONSABILIDADES:
 * - Exibir menus interativos
 * - Receber entrada de dados do usuário
 * - Validar entradas
 * - Chamar métodos do Service
 * - Exibir resultados e mensagens
 * 
 * (Fase Final: Sistema Consolidado)
 */
public class Menu {
    
    private AlunoService alunoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private TurmaService turmaService;
    private SistemaService sistemaService;
    private Scanner scanner;
    
    /**
     * Construtor do Menu
     */
    public Menu(AlunoService alunoService, ProfessorService professorService,
                CursoService cursoService, TurmaService turmaService,
                SistemaService sistemaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.cursoService = cursoService;
        this.turmaService = turmaService;
        this.sistemaService = sistemaService;
        this.scanner = new Scanner(System.in);
    }
    
    // ========== MÉTODO PRINCIPAL ==========
    
    /**
     * Inicia o loop principal do menu
     */
    public void iniciar() {
        boolean sair = false;
        
        while (!sair) {
            exibirMenuPrincipal();
            String opcao = obterEntrada("Escolha uma opção: ");
            
            switch (opcao.trim()) {
                case "1":
                    menuAlunos();
                    break;
                case "2":
                    menuProfessores();
                    break;
                case "3":
                    menuCursos();
                    break;
                case "4":
                    menuTurmas();
                    break;
                case "5":
                    menuAvaliacoes();
                    break;
                case "6":
                    menuRelatorios();
                    break;
                case "7":
                    sistemaService.exibirResumoSistema();
                    break;
                case "0":
                    sair = true;
                    System.out.println("\n✓ Encerrando o sistema... Até logo!\n");
                    break;
                default:
                    System.out.println("\n❌ Opção inválida! Tente novamente.\n");
            }
        }
        
        scanner.close();
    }
    
    // ========== MENUS PRINCIPAIS ==========
    
    private void exibirMenuPrincipal() {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║   🎓 SISTEMA DE GESTÃO EDUCACIONAL - EDUCONNECT          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("1. 👥 Gerenciar Alunos");
        System.out.println("2. 👨‍🏫 Gerenciar Professores");
        System.out.println("3. 📚 Gerenciar Cursos");
        System.out.println("4. 📖 Gerenciar Turmas");
        System.out.println("5. 📝 Registrar Avaliações");
        System.out.println("6. 📊 Gerar Relatórios");
        System.out.println("7. 📈 Resumo do Sistema");
        System.out.println("0. ❌ Sair");
        System.out.println("══════════════════════════════════════════════════════════\n");
    }
    
    // ========== MENU DE ALUNOS ==========
    
    private void menuAlunos() {
        boolean voltar = false;
        
        while (!voltar) {
            System.out.println("\n┌─ MENU DE ALUNOS ─────────────────────┐");
            System.out.println("│ 1. Cadastrar Aluno                   │");
            System.out.println("│ 2. Buscar Aluno                      │");
            System.out.println("│ 3. Listar Alunos                     │");
            System.out.println("│ 4. Remover Aluno                     │");
            System.out.println("│ 0. Voltar                            │");
            System.out.println("└──────────────────────────────────────┘");
            
            String opcao = obterEntrada("Escolha uma opção: ");
            
            switch (opcao.trim()) {
                case "1":
                    cadastrarAlunoInterativo();
                    break;
                case "2":
                    buscarAlunoInterativo();
                    break;
                case "3":
                    listarAlunos();
                    break;
                case "4":
                    removerAlunoInterativo();
                    break;
                case "0":
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }
    
    private void cadastrarAlunoInterativo() {
        System.out.println("\n--- CADASTRAR NOVO ALUNO ---");
        String nome = obterEntrada("Nome do aluno: ");
        String login = obterEntrada("Login: ");
        String senha = obterEntrada("Senha: ");
        String matricula = obterEntrada("Matrícula: ");
        String curso = obterEntrada("Curso: ");
        
        if (validarEntradas(nome, login, senha, matricula, curso)) {
            alunoService.cadastrarAluno(nome, login, senha, matricula, curso);
        } else {
            System.out.println("❌ Dados inválidos!");
        }
    }
    
    private void buscarAlunoInterativo() {
        String matricula = obterEntrada("Matrícula do aluno: ");
        Aluno aluno = alunoService.buscarPorMatricula(matricula);
        
        if (aluno != null) {
            aluno.gerarRelatorio();
        } else {
            System.out.println("❌ Aluno não encontrado!");
        }
    }
    
    private void listarAlunos() {
        List<Aluno> alunos = alunoService.listarTodos();
        
        if (alunos.isEmpty()) {
            System.out.println("\n❌ Nenhum aluno cadastrado!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       LISTA DE ALUNOS                  ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total: " + alunos.size() + " alunos\n");
        
        for (int i = 0; i < alunos.size(); i++) {
            Aluno a = alunos.get(i);
            System.out.println((i + 1) + ". " + a.getNome() + " (" + a.getMatricula() + ")");
        }
        System.out.println();
    }
    
    private void removerAlunoInterativo() {
        String matricula = obterEntrada("Matrícula do aluno a remover: ");
        alunoService.removerAluno(matricula);
    }
    
    // ========== MENU DE PROFESSORES ==========
    
    private void menuProfessores() {
        boolean voltar = false;
        
        while (!voltar) {
            System.out.println("\n┌─ MENU DE PROFESSORES ────────────────┐");
            System.out.println("│ 1. Cadastrar Professor               │");
            System.out.println("│ 2. Buscar Professor                  │");
            System.out.println("│ 3. Listar Professores                │");
            System.out.println("│ 4. Remover Professor                 │");
            System.out.println("│ 0. Voltar                            │");
            System.out.println("└──────────────────────────────────────┘");
            
            String opcao = obterEntrada("Escolha uma opção: ");
            
            switch (opcao.trim()) {
                case "1":
                    cadastrarProfessorInterativo();
                    break;
                case "2":
                    buscarProfessorInterativo();
                    break;
                case "3":
                    listarProfessores();
                    break;
                case "4":
                    removerProfessorInterativo();
                    break;
                case "0":
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }
    
    private void cadastrarProfessorInterativo() {
        System.out.println("\n--- CADASTRAR NOVO PROFESSOR ---");
        String nome = obterEntrada("Nome do professor: ");
        String login = obterEntrada("Login: ");
        String senha = obterEntrada("Senha: ");
        String especialidade = obterEntrada("Especialidade: ");
        String registro = obterEntrada("Registro: ");
        
        if (validarEntradas(nome, login, senha, especialidade, registro)) {
            professorService.cadastrarProfessor(nome, login, senha, especialidade, registro);
        } else {
            System.out.println("❌ Dados inválidos!");
        }
    }
    
    private void buscarProfessorInterativo() {
        String registro = obterEntrada("Registro do professor: ");
        Professor prof = professorService.buscarPorRegistro(registro);
        
        if (prof != null) {
            prof.gerarRelatorio();
        } else {
            System.out.println("❌ Professor não encontrado!");
        }
    }
    
    private void listarProfessores() {
        List<Professor> professores = professorService.listarTodos();
        
        if (professores.isEmpty()) {
            System.out.println("\n❌ Nenhum professor cadastrado!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       LISTA DE PROFESSORES             ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total: " + professores.size() + " professores\n");
        
        for (int i = 0; i < professores.size(); i++) {
            Professor p = professores.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " (" + p.getRegistro() + ")");
        }
        System.out.println();
    }
    
    private void removerProfessorInterativo() {
        String registro = obterEntrada("Registro do professor a remover: ");
        professorService.removerProfessor(registro);
    }
    
    // ========== MENU DE CURSOS ==========
    
    private void menuCursos() {
        boolean voltar = false;
        
        while (!voltar) {
            System.out.println("\n┌─ MENU DE CURSOS ─────────────────────┐");
            System.out.println("│ 1. Cadastrar Curso Presencial        │");
            System.out.println("│ 2. Cadastrar Curso EAD               │");
            System.out.println("│ 3. Listar Cursos                     │");
            System.out.println("│ 4. Remover Curso                     │");
            System.out.println("│ 0. Voltar                            │");
            System.out.println("└──────────────────────────────────────┘");
            
            String opcao = obterEntrada("Escolha uma opção: ");
            
            switch (opcao.trim()) {
                case "1":
                    cadastrarCursoPresencialInterativo();
                    break;
                case "2":
                    cadastrarCursoEADInterativo();
                    break;
                case "3":
                    listarCursos();
                    break;
                case "4":
                    removerCursoInterativo();
                    break;
                case "0":
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }
    
    private void cadastrarCursoPresencialInterativo() {
        System.out.println("\n--- CADASTRAR CURSO PRESENCIAL ---");
        String nome = obterEntrada("Nome do curso: ");
        String codigo = obterEntrada("Código: ");
        String cargaStr = obterEntrada("Carga horária: ");
        String sala = obterEntrada("Sala de aula: ");
        
        try {
            double carga = Double.parseDouble(cargaStr);
            cursoService.cadastrarCursoPresencial(nome, codigo, carga, sala);
        } catch (NumberFormatException e) {
            System.out.println("❌ Carga horária inválida!");
        }
    }
    
    private void cadastrarCursoEADInterativo() {
        System.out.println("\n--- CADASTRAR CURSO EAD ---");
        String nome = obterEntrada("Nome do curso: ");
        String codigo = obterEntrada("Código: ");
        String cargaStr = obterEntrada("Carga horária: ");
        String plataforma = obterEntrada("Plataforma virtual: ");
        
        try {
            double carga = Double.parseDouble(cargaStr);
            cursoService.cadastrarCursoEAD(nome, codigo, carga, plataforma);
        } catch (NumberFormatException e) {
            System.out.println("❌ Carga horária inválida!");
        }
    }
    
    private void listarCursos() {
        List<Curso> cursos = cursoService.listarTodos();
        
        if (cursos.isEmpty()) {
            System.out.println("\n❌ Nenhum curso cadastrado!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        LISTA DE CURSOS                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total: " + cursos.size() + " cursos\n");
        
        for (int i = 0; i < cursos.size(); i++) {
            Curso c = cursos.get(i);
            System.out.println((i + 1) + ". " + c.getNome() + " (" + c.getCodigo() + ")");
        }
        System.out.println();
    }
    
    private void removerCursoInterativo() {
        String codigo = obterEntrada("Código do curso a remover: ");
        cursoService.removerCurso(codigo);
    }
    
    // ========== MENU DE TURMAS ==========
    
    private void menuTurmas() {
        boolean voltar = false;
        
        while (!voltar) {
            System.out.println("\n┌─ MENU DE TURMAS ─────────────────────┐");
            System.out.println("│ 1. Criar Turma                       │");
            System.out.println("│ 2. Listar Turmas                     │");
            System.out.println("│ 3. Ver Detalhes da Turma             │");
            System.out.println("│ 0. Voltar                            │");
            System.out.println("└──────────────────────────────────────┘");
            
            String opcao = obterEntrada("Escolha uma opção: ");
            
            switch (opcao.trim()) {
                case "1":
                    criarTurmaInterativo();
                    break;
                case "2":
                    listarTurmas();
                    break;
                case "3":
                    verDetalhesTurmaInterativo();
                    break;
                case "0":
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }
    
    private void criarTurmaInterativo() {
        System.out.println("\n--- CRIAR NOVA TURMA ---");
        String codigo = obterEntrada("Código da turma: ");
        
        if (alunoService.contar() == 0 || professorService.contar() == 0 || cursoService.contar() == 0) {
            System.out.println("❌ Erro: É necessário ter alunos, professores e cursos cadastrados!");
            return;
        }
        
        String registroProf = obterEntrada("Registro do professor: ");
        Professor prof = professorService.buscarPorRegistro(registroProf);
        
        if (prof == null) {
            System.out.println("❌ Professor não encontrado!");
            return;
        }
        
        String codigoCurso = obterEntrada("Código do curso: ");
        Curso curso = cursoService.buscarPorCodigo(codigoCurso);
        
        if (curso == null) {
            System.out.println("❌ Curso não encontrado!");
            return;
        }
        
        turmaService.cadastrarTurma(codigo, prof, curso);
    }
    
    private void listarTurmas() {
        List<Turma> turmas = turmaService.listarTodas();
        
        if (turmas.isEmpty()) {
            System.out.println("\n❌ Nenhuma turma cadastrada!");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        LISTA DE TURMAS                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total: " + turmas.size() + " turmas\n");
        
        for (int i = 0; i < turmas.size(); i++) {
            Turma t = turmas.get(i);
            System.out.println((i + 1) + ". " + t.getCodigo() + " - " + t.getCurso().getNome() +
                             " (" + t.getProfessor().getNome() + ")");
        }
        System.out.println();
    }
    
    private void verDetalhesTurmaInterativo() {
        String codigo = obterEntrada("Código da turma: ");
        Turma turma = turmaService.buscarPorCodigo(codigo);
        
        if (turma != null) {
            turma.resumoTurma();
        } else {
            System.out.println("❌ Turma não encontrada!");
        }
    }
    
    // ========== MENU DE AVALIAÇÕES ==========
    
    private void menuAvaliacoes() {
        System.out.println("\n--- REGISTRAR AVALIAÇÃO ---");
        String matricula = obterEntrada("Matrícula do aluno: ");
        Aluno aluno = alunoService.buscarPorMatricula(matricula);
        
        if (aluno == null) {
            System.out.println("❌ Aluno não encontrado!");
            return;
        }
        
        String descricao = obterEntrada("Descrição da avaliação: ");
        String notaStr = obterEntrada("Nota (0-10): ");
        
        try {
            double nota = Double.parseDouble(notaStr);
            Avaliacao av = new Avaliacao(descricao, aluno);
            if (av.atribuirNota(nota)) {
                System.out.println("✓ Avaliação registrada com sucesso!");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Nota inválida!");
        }
    }
    
    // ========== MENU DE RELATÓRIOS ==========
    
    private void menuRelatorios() {
        boolean voltar = false;
        
        while (!voltar) {
            System.out.println("\n┌─ MENU DE RELATÓRIOS ─────────────────┐");
            System.out.println("│ 1. Relatório de Alunos               │");
            System.out.println("│ 2. Relatório de Professores          │");
            System.out.println("│ 3. Relatório de Cursos               │");
            System.out.println("│ 4. Relatório de Turmas               │");
            System.out.println("│ 5. Relatório Completo do Sistema     │");
            System.out.println("│ 0. Voltar                            │");
            System.out.println("└──────────────────────────────────────┘");
            
            String opcao = obterEntrada("Escolha uma opção: ");
            
            switch (opcao.trim()) {
                case "1":
                    alunoService.gerarRelatorioAlunos();
                    break;
                case "2":
                    professorService.gerarRelatorioProfessores();
                    break;
                case "3":
                    cursoService.gerarRelatorioCursos();
                    break;
                case "4":
                    turmaService.gerarRelatorioTurmas();
                    break;
                case "5":
                    sistemaService.gerarRelatorioCompleto();
                    break;
                case "0":
                    voltar = true;
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }
    }
    
    // ========== MÉTODOS AUXILIARES ==========
    
    private String obterEntrada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
    
    private boolean validarEntradas(String... entradas) {
        for (String entrada : entradas) {
            if (entrada == null || entrada.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}