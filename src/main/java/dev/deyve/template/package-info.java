/**
 * <h2>Template Method (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Definir o esqueleto de um algoritmo em uma classe
 * base, deixando que subclasses sobrescrevam passos específicos sem
 * alterar a estrutura do algoritmo.
 *
 * <p><b>Problema:</b> Vários algoritmos compartilham a mesma estrutura
 * geral, mas diferem em alguns passos.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Reuso da estrutura do algoritmo.</li>
 *   <li>+ Inversão de controle — a base chama a subclasse
 *       (<i>Hollywood Principle</i>).</li>
 *   <li>- Acoplamento forte via herança.</li>
 *   <li>- Risco de violar o Princípio da Substituição de Liskov.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> passos variam de forma radical entre
 * implementações — prefira <i>Strategy</i> (composição).
 */
package dev.deyve.template;
