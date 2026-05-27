/**
 * <h2>Flyweight (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Compartilhar objetos pequenos e imutáveis para
 * suportar grandes quantidades deles com pouco uso de memória, separando
 * estado intrínseco (compartilhável) de extrínseco (passado pelo cliente).
 *
 * <p><b>Problema:</b> Você precisa instanciar milhões de objetos quase
 * idênticos (caracteres num editor, árvores num jogo, partículas) — a
 * memória vai pra lua.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Economia de memória massiva quando há repetição.</li>
 *   <li>- Adiciona complexidade — split entre intrínseco/extrínseco precisa
 *       ser explícito.</li>
 *   <li>- Objetos compartilhados precisam ser imutáveis (estado de um
 *       contamina todos os outros usuários).</li>
 *   <li>- Pode trocar memória por CPU (cache lookup).</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> poucos objetos no total, ou estado quase todo
 * variável — não há o que compartilhar.
 */
package dev.deyve.flyweight;
