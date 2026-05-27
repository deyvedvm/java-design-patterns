/**
 * <h2>Observer (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Definir uma dependência um-para-muitos entre objetos,
 * de modo que quando o sujeito muda de estado, todos os observadores são
 * notificados automaticamente.
 *
 * <p><b>Problema:</b> Várias partes do sistema precisam reagir a uma mesma
 * mudança, sem que o sujeito conheça cada uma delas.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Sujeito desacoplado dos observadores concretos.</li>
 *   <li>+ Suporta <i>broadcast</i> dinâmico (registrar/desregistrar em runtime).</li>
 *   <li>- Ordem de notificação não é garantida.</li>
 *   <li>- Risco de <i>memory leak</i> se observers não desregistrarem.</li>
 *   <li>- Cascatas de notificação podem ser difíceis de depurar.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> comunicação 1-para-1 simples — um callback
 * direto é mais claro.
 *
 * <p>Relacionado a <i>Mediator</i> (ambos desacoplam comunicação, mas
 * Mediator centraliza em um terceiro objeto).
 */
package dev.deyve.observer;
