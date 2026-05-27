/**
 * <h2>Visitor (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Representar uma operação a ser executada sobre os
 * elementos de uma estrutura de objetos, permitindo definir novas
 * operações sem alterar as classes dos elementos.
 *
 * <p><b>Problema:</b> Adicionar operações novas a uma hierarquia já
 * estável de classes (ex.: render como HTML, exportar como Markdown,
 * calcular peso) sem modificar cada classe.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Operações relacionadas ficam juntas em um único Visitor.</li>
 *   <li>+ Adicionar operação = nova classe Visitor (não toca a hierarquia).</li>
 *   <li>- Adicionar <i>novo nó</i> na hierarquia quebra todos os Visitors.</li>
 *   <li>- <i>Double dispatch</i> em Java é verboso
 *       ({@code element.accept(visitor)} → {@code visitor.visit(element)}).</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> a hierarquia muda com mais frequência do que
 * as operações.
 */
package dev.deyve.visitor;
