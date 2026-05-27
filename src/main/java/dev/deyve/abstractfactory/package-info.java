/**
 * <h2>Abstract Factory (Criacional)</h2>
 *
 * <p><b>Intenção:</b> Fornecer uma interface para criar <i>famílias</i> de
 * objetos relacionados sem especificar suas classes concretas.
 *
 * <p><b>Problema:</b> Garantir que objetos criados juntos sejam compatíveis
 * entre si (ex.: GUI inteira no estilo Windows ou Mac, nunca misturada).
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Consistência de família garantida pela fábrica.</li>
 *   <li>+ Trocar a família inteira muda apenas uma linha
 *       ({@code new MacFactory()}).</li>
 *   <li>- Adicionar um <i>novo produto</i> à família obriga mudar a
 *       interface da fábrica e todas as suas implementações.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> quando há apenas um produto a criar. Use
 * <i>Factory Method</i> — Abstract Factory só compensa quando há família
 * com 2+ produtos relacionados.
 */
package dev.deyve.abstractfactory;
