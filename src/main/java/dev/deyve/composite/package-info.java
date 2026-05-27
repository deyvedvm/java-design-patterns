/**
 * <h2>Composite (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Compor objetos em estruturas de árvore para
 * representar hierarquias parte-todo, tratando objetos individuais e
 * composições de objetos de maneira uniforme.
 *
 * <p><b>Problema:</b> Cliente precisa percorrer uma estrutura recursiva
 * (árvore de menus, sistema de arquivos, organograma) sem se importar se
 * o nó é folha ou composto.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Cliente trata folha e composto com a mesma interface.</li>
 *   <li>+ Operações recursivas ficam naturais.</li>
 *   <li>- Pode forçar uma interface "menor denominador comum" que não
 *       faz sentido para folhas (ex.: {@code add()} em File).</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> estrutura não é recursiva — não force
 * Composite quando uma lista plana resolve.
 */
package dev.deyve.composite;
