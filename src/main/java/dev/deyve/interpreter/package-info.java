/**
 * <h2>Interpreter (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Dada uma linguagem, definir uma representação para
 * sua gramática junto com um interpretador que usa essa representação
 * para interpretar sentenças.
 *
 * <p><b>Problema:</b> Você precisa avaliar repetidamente expressões de uma
 * linguagem pequena (filtros, regras de negócio, queries simples) e quer
 * a árvore sintática como dado de primeira classe.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Cada regra gramatical é uma classe — fácil estender com novas
 *       operações.</li>
 *   <li>+ Casa naturalmente com <i>Composite</i> (a AST é uma árvore).</li>
 *   <li>- Gramáticas grandes explodem em número de classes — use
 *       <i>parser generators</i> (ANTLR, JavaCC) em vez disso.</li>
 *   <li>- Performance ruim para expressões complexas (cada nó é uma
 *       chamada virtual).</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> gramática complexa ou performance crítica —
 * adote uma ferramenta de parser dedicada.
 */
package dev.deyve.interpreter;
