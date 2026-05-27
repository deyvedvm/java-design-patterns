/**
 * <h2>Chain of Responsibility (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Passar uma requisição por uma cadeia de handlers até
 * que um deles a trate (ou a cadeia chegue ao fim).
 *
 * <p><b>Problema:</b> Múltiplos handlers possíveis para a mesma requisição,
 * com ordem importante (ex.: autenticação → log → compressão).
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Emissor não conhece o receptor — desacoplamento.</li>
 *   <li>+ Adicionar/reordenar handlers é só mudar o encadeamento.</li>
 *   <li>- Requisição pode "cair fora da cadeia" sem ninguém tratar.</li>
 *   <li>- Depurar cadeias longas é custoso.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> um único handler conhecido em tempo de
 * compilação — chame-o diretamente.
 *
 * <p>Relacionado a <i>Decorator</i> (ambos encadeiam, mas Decorator
 * <i>compõe</i> comportamento; CoR <i>elege</i> quem trata).
 */
package dev.deyve.chainofresponsibility;
