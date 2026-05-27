/**
 * <h2>Bridge (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Desacoplar uma abstração de sua implementação,
 * permitindo que as duas variem de forma independente.
 *
 * <p><b>Problema:</b> Você tem M variações de abstração × N variações de
 * implementação. Hierarquia única gera M×N classes (explosão combinatória).
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Cresce em M+N classes em vez de M×N.</li>
 *   <li>+ Abstração e implementação evoluem separadamente.</li>
 *   <li>- Mais indireção — pode ser overkill quando há poucas variações.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> apenas uma dimensão variando — herança simples
 * resolve.
 */
package dev.deyve.bridge;
