# 🎓 Sistema de Gestão Educacional (SGE) - EduConnect

## 📋 Visão Geral

O **Sistema de Gestão Educacional (SGE)** é uma solução profissional e completa desenvolvida em Java para gerenciar todas as operações de uma instituição educacional moderna. O sistema foi criado seguindo as melhores práticas de engenharia de software, com arquitetura em camadas e princípios SOLID.

### 🎯 Objetivo Principal

Fornecer uma plataforma integrada que permite:
- 👥 Gerenciar alunos, professores e cursos
- 📖 Organizar turmas e associações
- 📝 Registrar e controlar avaliações
- 📊 Gerar relatórios automáticos e personalizados
- 🔐 Autenticação de usuários com perfis específicos

---

## 🚀 Recursos Principais

### ✨ Funcionalidades Implementadas

#### 1. **Gerenciamento de Alunos**
- Cadastro de alunos com informações acadêmicas
- Busca por matrícula
- Listagem completa
- Remoção de registros
- Autenticação com login e senha

#### 2. **Gerenciamento de Professores**
- Cadastro de professores com especialidade
- Busca por registro profissional
- Listagem de professores
- Remoção de registros
- Autenticação com permissões

#### 3. **Gerenciamento de Cursos**
- Cadastro de cursos presenciais
- Cadastro de cursos EAD (Educação a Distância)
- Informações de sala de aula ou plataforma virtual
- Listagem com filtros
- Remoção de cursos

#### 4. **Gestão de Turmas**
- Criação de turmas associando professor, curso e alunos
- Adição/remoção de alunos em turmas
- Visualização de resumo da turma
- Gerenciamento de múltiplas turmas

#### 5. **Controle de Avaliações**
- Registro de notas com validação (0-10)
- Encapsulamento de dados de avaliação
- Cálculo de médias por aluno
- Classificação de situação (Aprovado/Recuperação/Reprovado)
- Associação de avaliações a turmas

#### 6. **Sistema de Relatórios**
- Relatórios de alunos
- Relatórios de professores
- Relatórios de cursos
- Relatórios de turmas
- Relatório completo do sistema com estatísticas

#### 7. **Autenticação e Controle de Acesso**
- Três perfis de usuário: Aluno, Professor, Administrador
- Sistema de autenticação com login/senha
- Controle de permissões por nível
- Validações de acesso

#### 8. **Menu Interativo**
- Interface amigável e intuitiva
- Menus aninhados para cada funcionalidade
- Validação de entrada de dados
- Mensagens de erro/sucesso claras
- Dados de demonstração pré-carregados

---

## 🏗️ Arquitetura do Projeto

### Estrutura em Camadas

O projeto segue a arquitetura em **3 camadas** profissional:

```
┌─────────────────────────────────────────────────┐
│         CAMADA UI (Apresentação)                │
│    Menu.java - Interface com Usuário            │
└──────────────┬──────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────┐
│       CAMADA SERVICE (Lógica de Negócio)        │
│  AlunoService, ProfessorService, CursoService  │
│  TurmaService, SistemaService                  │
└──────────────┬──────────────────────────────────┘
               │
┌──────────────▼──────────────────────────────────┐
│   CAMADA REPOSITORY (Persistência/Dados)        │
│  AlunoRepository, ProfessorRepository,          │
│  CursoRepository, TurmaRepository               │
└─────────────────────────────────────────────────┘
```

### Estrutura de Diretórios

```
SistemaGestaoEducacional/
│
├── src/
│   ├── model/                    # Entidades do sistema
│   │   ├── Aluno.java
│   │   ├── Professor.java
│   │   ├── Curso.java
│   │   ├── CursoPresencial.java
│   │   ├── CursoEAD.java
│   │   ├── Turma.java
│   │   ├── Avaliacao.java
│   │   ├── Usuario.java          # Classe abstrata
│   │   ├── Administrador.java
│   │   ├── Autenticavel.java     # Interface
│   │   └── Relatorio.java        # Interface
│   │
│   ├── repository/               # Camada de Dados
│   │   ├── AlunoRepository.java
│   │   ├── ProfessorRepository.java
│   │   ├── CursoRepository.java
│   │   └── TurmaRepository.java
│   │
│   ├── service/                  # Camada de Negócio
│   │   ├── AlunoService.java
│   │   ├── ProfessorService.java
│   │   ├── CursoService.java
│   │   ├── TurmaService.java
│   │   └── SistemaService.java
│   │
│   ├── ui/                       # Camada de Apresentação
│   │   └── Menu.java
│   │
│   └── Main.java                 # Ponto de entrada
│
├── README.md                      # Este arquivo
└── .gitignore                     # Arquivos a ignorar
```

---

## 💻 Requisitos do Sistema

### Pré-requisitos

- **Java Development Kit (JDK)** versão 11 ou superior
- **Visual Studio Code** (ou qualquer IDE Java)
- **Extension Pack for Java** (para VSCode)

### Instalação do Ambiente

#### 1. Instalar Java JDK

**Windows:**
- Acesse: https://www.oracle.com/java/technologies/downloads/
- Baixe Java 21 LTS
- Siga o instalador

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```

**Mac:**
```bash
brew install openjdk@21
```

#### 2. Verificar Instalação

```bash
java -version
```

#### 3. Instalar VSCode e Extensões

- Baixe VSCode: https://code.visualstudio.com/
- Instale a extensão "Extension Pack for Java"

---

## 🚀 Como Executar

### Opção 1: Executar via VSCode

1. **Abra o projeto** no VSCode:
   ```bash
   code SistemaGestaoEducacional
   ```

2. **Navegue até** `src/Main.java`

3. **Clique em "Run"** ou pressione `Ctrl+F5`

### Opção 2: Executar via Terminal

```bash
cd SistemaGestaoEducacional
javac -d out src/model/*.java src/repository/*.java src/service/*.java src/ui/*.java src/Main.java
java -cp out Main
```

### Opção 3: Compilar e Executar com um Script

**Linux/Mac:**
```bash
chmod +x run.sh
./run.sh
```

**Windows:**
```bash
run.bat
```

---

## 📖 Guia de Uso

### Menu Principal

Ao iniciar o sistema, você verá o menu principal:

```
╔══════════════════════════════════════════════════════════╗
║   🎓 SISTEMA DE GESTÃO EDUCACIONAL - EDUCONNECT          ║
╚══════════════════════════════════════════════════════════╝
1. 👥 Gerenciar Alunos
2. 👨‍🏫 Gerenciar Professores
3. 📚 Gerenciar Cursos
4. 📖 Gerenciar Turmas
5. 📝 Registrar Avaliações
6. 📊 Gerar Relatórios
7. 📈 Resumo do Sistema
0. ❌ Sair
```

### Operações Principais

#### ➕ Cadastrar Aluno

1. Selecione **"1 - Gerenciar Alunos"**
2. Escolha **"1 - Cadastrar Aluno"**
3. Preencha os dados:
   - Nome
   - Login
   - Senha
   - Matrícula
   - Curso

#### ➕ Cadastrar Professor

1. Selecione **"2 - Gerenciar Professores"**
2. Escolha **"1 - Cadastrar Professor"**
3. Preencha os dados:
   - Nome
   - Login
   - Senha
   - Especialidade
   - Registro

#### ➕ Criar Curso

1. Selecione **"3 - Gerenciar Cursos"**
2. Escolha **"1 - Cadastrar Curso Presencial"** ou **"2 - Cadastrar Curso EAD"**
3. Preencha os dados:
   - Nome do curso
   - Código
   - Carga horária
   - Sala de aula (presencial) ou Plataforma (EAD)

#### 📖 Criar Turma

1. Selecione **"4 - Gerenciar Turmas"**
2. Escolha **"1 - Criar Turma"**
3. Forneça:
   - Código da turma
   - Registro do professor
   - Código do curso

#### 📝 Registrar Avaliação

1. Selecione **"5 - Registrar Avaliações"**
2. Forneça:
   - Matrícula do aluno
   - Descrição da avaliação
   - Nota (0-10)

#### 📊 Gerar Relatórios

1. Selecione **"6 - Gerar Relatórios"**
2. Escolha entre:
   - Relatório de Alunos
   - Relatório de Professores
   - Relatório de Cursos
   - Relatório de Turmas
   - Relatório Completo do Sistema

---

## 🎓 Conceitos de Programação Orientada a Objetos

Este projeto implementa todos os conceitos principais de POO:

### 1. **Classes e Objetos**
```java
Aluno aluno = new Aluno("João", "joao", "123", "2024001", "Eng");
```

### 2. **Encapsulamento**
```java
private double nota;  // Atributo privado

public boolean atribuirNota(double valor) {  // Método de acesso controlado
    if (valor >= 0 && valor <= 10) {
        this.nota = valor;
        return true;
    }
    return false;
}
```

### 3. **Herança**
```java
public class CursoPresencial extends Curso {
    // Herda de Curso
}

public class Aluno extends Usuario {
    // Herda de Usuario
}
```

### 4. **Polimorfismo**
```java
@Override
public void gerarRelatorio() {
    // Cada classe tem sua própria implementação
}
```

### 5. **Interfaces**
```java
public interface Autenticavel {
    boolean autenticar(String login, String senha);
}

public class Aluno implements Autenticavel {
    // Implementa a interface
}
```

### 6. **Classes Abstratas**
```java
public abstract class Usuario implements Autenticavel, Relatorio {
    public abstract String obterPerfil();
    public abstract void gerarRelatorio();
}
```

### 7. **Composição**
```java
public class Turma {
    private Professor professor;  // Composição
    private Curso curso;          // Composição
    private List<Aluno> alunos;   // Composição
}
```

---

## 🔒 Sistema de Autenticação

O sistema implementa três perfis de usuário:

### 👤 Aluno
- **Permissões:** Visualizar dados pessoais, ver notas
- **Autenticação:** Login/Senha (validação simples)
- **Acesso:** Limitado a seus próprios dados

### 👨‍🏫 Professor
- **Permissões:** Visualizar turmas, lançar notas
- **Autenticação:** Login/Senha (validação simples)
- **Acesso:** Dados da turma e alunos

### 🔐 Administrador
- **Permissões:** Acesso total ao sistema
- **Autenticação:** Login/Senha (validação rigorosa)
- **Níveis de Acesso:** BAIXO, MÉDIO, ALTO

---

## 📊 Exemplos de Uso

### Exemplo 1: Listar Todos os Alunos

```
Menu Principal → 1 (Alunos) → 3 (Listar Alunos)

╔════════════════════════════════════════╗
║       LISTA DE ALUNOS                  ║
╚════════════════════════════════════════╝
Total: 3 alunos

1. João Silva (2024001)
2. Maria Santos (2024002)
3. Pedro Costa (2024003)
```

### Exemplo 2: Gerar Relatório de Aluno

```
Menu Principal → 6 (Relatórios) → 1 (Alunos)

╔════════════════════════════════════════╗
║        RELATÓRIO DO ALUNO              ║
╚════════════════════════════════════════╝
📊 DADOS PESSOAIS:
  Nome: João Silva
  Login: joao
  Perfil: ALUNO

📚 DADOS ACADÊMICOS:
  Matrícula: 2024001
  Curso: Engenharia
════════════════════════════════════════
```

### Exemplo 3: Registrar Avaliação

```
Menu Principal → 5 (Avaliações)

Matrícula do aluno: 2024001
Descrição da avaliação: Prova 1
Nota (0-10): 8.5

✓ Nota 8.5 atribuída com sucesso para João Silva
```

---

## ✅ Validações Implementadas

O sistema realiza validações em múltiplos níveis:

### Validações de Entrada
- ✅ Campos não podem estar vazios
- ✅ Notas devem estar entre 0 e 10
- ✅ Matriculas/Registros devem ser únicos
- ✅ Formato de números validado

### Validações de Negócio
- ✅ Aluno duplicado não pode ser adicionado
- ✅ Professor deve existir para criar turma
- ✅ Curso deve existir para criar turma
- ✅ Nota inválida é rejeitada

### Validações de Acesso
- ✅ Login/Senha incorretos rejeitados
- ✅ Campos vazios validados
- ✅ Tipos de usuário verificados

---

## 🧪 Cenários de Teste

### ✅ Cenários de Sucesso

1. **Cadastrar um novo aluno**
   - Resultado esperado: "✓ Aluno ... cadastrado com sucesso!"

2. **Criar uma turma com professor e curso válidos**
   - Resultado esperado: "✓ Turma ... cadastrada com sucesso!"

3. **Registrar avaliação com nota válida**
   - Resultado esperado: "✓ Nota ... atribuída com sucesso!"

4. **Gerar relatório de alunos**
   - Resultado esperado: Lista completa com dados formatados

### ❌ Cenários de Falha

1. **Cadastrar aluno com matrícula duplicada**
   - Resultado esperado: "❌ Erro: Aluno com matrícula ... já existe!"

2. **Atribuir nota inválida (< 0 ou > 10)**
   - Resultado esperado: "❌ ERRO: Nota não pode ser ... !"

3. **Criar turma sem professor**
   - Resultado esperado: "❌ Professor não encontrado!"

4. **Tentar autenticar com senha incorreta**
   - Resultado esperado: "❌ Senha incorreta!"

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| Java | 11+ | Linguagem de programação |
| JDK | 21 LTS | Kit de desenvolvimento |
| Collections | - | ArrayList, List para armazenamento |
| Scanner | - | Entrada de dados do usuário |

---

## 📈 Estatísticas do Projeto

- **Total de Classes:** 24
- **Total de Linhas de Código:** ~3.500+
- **Interfaces Implementadas:** 2
- **Classes Abstratas:** 1
- **Métodos Implementados:** 150+
- **Fases de Desenvolvimento:** 8

---

## 🎯 Objetivos de Aprendizado

Este projeto demonstra domínio em:

✅ **Programação Orientada a Objetos**
- Classes, herança, polimorfismo, interfaces

✅ **Arquitetura de Software**
- Padrão em camadas, separação de responsabilidades

✅ **Princípios SOLID**
- Single Responsibility, Open/Closed, Liskov Substitution

✅ **Boas Práticas**
- Nomes significativos, documentação, validações

✅ **Estruturas de Dados**
- ArrayList, List, iteração

✅ **Tratamento de Exceções**
- Try-catch, validações robustas

---

## 🚀 Melhorias Futuras

### Versão 2.0 (Planejado)

- [ ] Integração com banco de dados (MySQL, PostgreSQL)
- [ ] Interface gráfica (Swing, JavaFX)
- [ ] API REST para integração com outros sistemas
- [ ] Autenticação JWT
- [ ] Backup e restore de dados
- [ ] Relatórios em PDF
- [ ] Sistema de permissões granular
- [ ] Auditoria de ações
- [ ] Dashboard com gráficos

---

## 📝 Licença

Este projeto é fornecido como material educacional para a disciplina de **Imersão Profissional - Aplicando Orientação a Objetos**.

---

## 👥 Autor

**Desenvolvedor:** [Seu Nome]  
**Data de Conclusão:** [Data]  
**Instituição:** [Instituição Educacional]

---

## 📞 Suporte

Para dúvidas ou problemas:

1. Consulte a documentação do código (comentários)
2. Revise os exemplos de uso acima
3. Teste os cenários propostos
4. Contacte o suporte técnico

---

## 📚 Referências

- [Oracle Java Documentation](https://docs.oracle.com/javase/)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)
- [Clean Code Principles](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)
- [Design Patterns](https://refactoring.guru/design-patterns/java)

---

## 🎉 Conclusão

O **Sistema de Gestão Educacional (SGE)** é um exemplo completo de como desenvolver uma aplicação profissional em Java seguindo as melhores práticas de engenharia de software. O projeto integra todos os conceitos fundamentais de Programação Orientada a Objetos e serve como base sólida para aplicações mais complexas.

**Parabéns ao completar este projeto!** 🏆

---

**Versão:** 1.0  
**Status:** ✅ Completo  
**Última Atualização:** 2024
