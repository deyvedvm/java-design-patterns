/**
 * <h2>Iterator (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Fornecer uma forma de acessar elementos de uma
 * coleção sequencialmente, sem expor sua representação interna.
 *
 * <p><b>Problema:</b> Cliente precisa percorrer uma coleção sem saber se é
 * lista, árvore, grafo ou outra estrutura.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Desacopla o cliente da estrutura de dados.</li>
 *   <li>+ Permite múltiplas travessias simultâneas e independentes.</li>
 *   <li>- Em Java, {@link java.util.Iterator} + {@link java.lang.Iterable}
 *       já cobrem 95% dos casos — reimplementar do zero geralmente é
 *       desnecessário.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> quando {@code for-each} sobre {@code Iterable}
 * já resolve.
 */
package dev.deyve.iterator;
