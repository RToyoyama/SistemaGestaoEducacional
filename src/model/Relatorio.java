package model;

/**
 * Interface Relatorio
 * Define o contrato para classes que geram relatórios
 * Qualquer classe que implemente esta interface DEVE ter um método gerarRelatorio()
 * 
 * (Fase 6: Relatórios e Estatísticas - Polimorfismo)
 */
public interface Relatorio {
    
    /**
     * Gera um relatório com as informações da entidade
     * Cada implementação terá sua forma própria de gerar relatório
     */
    void gerarRelatorio();
    
}