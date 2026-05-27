/**
 * <h2>Memento (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Capturar e externalizar o estado interno de um
 * objeto, sem violar seu encapsulamento, para que possa ser restaurado
 * depois.
 *
 * <p><b>Problema:</b> Implementar <i>undo/redo</i>, <i>snapshots</i>,
 * transações com <i>rollback</i>.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Encapsulamento do <i>originator</i> preservado.</li>
 *   <li>+ Histórico de estados restaurável a qualquer momento.</li>
 *   <li>- Consumo de memória cresce com o tamanho do histórico.</li>
 *   <li>- Memento precisa acessar campos privados do originator —
 *       em Java resolve-se com inner class ou pacote.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> estado pequeno e simples — basta clonar
 * diretamente.
 */
package dev.deyve.memento;
