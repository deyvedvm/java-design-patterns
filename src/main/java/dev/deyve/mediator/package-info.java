/**
 * <h2>Mediator (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Definir um objeto que centraliza a comunicação entre
 * vários componentes, evitando que cada um conheça os outros diretamente.
 *
 * <p><b>Problema:</b> N componentes que conversam mutuamente formam um
 * grafo "n×n" de dependências, difícil de manter.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Componentes ficam isolados, reutilizáveis.</li>
 *   <li>+ Lógica de coordenação concentrada em um único lugar.</li>
 *   <li>- O mediator pode crescer e virar um <i>God Object</i>.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> poucos componentes (2-3) com pouca interação
 * — comunicação direta é mais simples.
 *
 * <p>Relacionado a <i>Observer</i>: ambos desacoplam, mas Observer é
 * broadcast e Mediator é coordenação dirigida.
 */
package dev.deyve.mediator;
