/**
 * <h2>Command (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Encapsular uma requisição como um objeto, permitindo
 * parametrizar clientes com operações, enfileirá-las, registrá-las em log
 * e suportar operações reversíveis.
 *
 * <p><b>Problema:</b> O <i>invoker</i> precisa disparar ações sem saber
 * exatamente o que cada uma faz (botões de UI, jobs em fila, undo/redo).
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Desacopla quem invoca de quem executa.</li>
 *   <li>+ Habilita undo/redo, filas, log, transação.</li>
 *   <li>- Uma classe por ação (verboso) — em Java moderno, lambdas
 *       resolvem comandos sem estado.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> chamada direta resolve e não há necessidade
 * de enfileirar, desfazer ou registrar.
 */
package dev.deyve.command;
