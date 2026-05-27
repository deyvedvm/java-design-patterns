/**
 * <h2>Strategy (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Definir uma família de algoritmos, encapsular cada
 * um, e torná-los intercambiáveis em runtime.
 *
 * <p><b>Problema:</b> A mesma tarefa admite múltiplas implementações
 * (compressão, ordenação, filtro), escolhidas em runtime sem
 * recompilar/duplicar código.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Algoritmos isolados, fáceis de testar.</li>
 *   <li>+ Trocar comportamento por composição, sem herança.</li>
 *   <li>- Cliente precisa conhecer as estratégias para escolher uma.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> um único algoritmo estável e improvável de
 * mudar — não generalize prematuramente.
 *
 * <p>Relacionado a <i>State</i> (mesma estrutura, intenção diferente) e a
 * <i>Template Method</i> (composição vs. herança para variar passos).
 */
package dev.deyve.strategy;
