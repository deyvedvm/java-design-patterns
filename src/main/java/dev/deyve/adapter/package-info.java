/**
 * <h2>Adapter (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Converter a interface de uma classe em outra interface
 * esperada pelo cliente. Permite que classes incompatíveis trabalhem juntas.
 *
 * <p><b>Problema:</b> Você tem uma classe (geralmente legada ou de terceiros)
 * cuja API não bate com a interface que seu código espera, e modificá-la
 * não é viável.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Princípio Aberto/Fechado: novo adapter sem mexer no cliente nem no adaptee.</li>
 *   <li>+ Isola código de terceiros atrás de uma interface sua.</li>
 *   <li>- Aumenta o número de classes.</li>
 *   <li>- Pode esconder problemas reais de design — abuso vira "adapter para
 *       adapter".</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> quando você controla as duas pontas — refatore
 * a interface diretamente em vez de adicionar uma camada.
 */
package dev.deyve.adapter;
