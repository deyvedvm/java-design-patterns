/**
 * <h2>Decorator (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Adicionar responsabilidades a um objeto dinamicamente,
 * empilhando "envoltórios" que implementam a mesma interface do objeto.
 *
 * <p><b>Problema:</b> Você quer combinar comportamentos opcionais
 * (criptografia + compressão + log) sem explodir a hierarquia em
 * subclasses para cada combinação.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Composição em runtime — combine como quiser.</li>
 *   <li>+ Princípio da Responsabilidade Única (cada decorator faz uma coisa).</li>
 *   <li>- Pilhas profundas dificultam o debug (qual decorator falhou?).</li>
 *   <li>- Identidade do objeto se perde (o wrapper não é {@code equals} ao wrappee).</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> só uma combinação fixa de comportamentos é
 * necessária — uma subclasse simples basta.
 *
 * <p>Relacionado a <i>Chain of Responsibility</i>: ambos encadeiam, mas
 * Decorator <i>compõe</i> comportamento e CoR <i>elege</i> um handler.
 */
package dev.deyve.decorator;
