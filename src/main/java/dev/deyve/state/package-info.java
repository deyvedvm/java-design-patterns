/**
 * <h2>State (Comportamental)</h2>
 *
 * <p><b>Intenção:</b> Permitir que um objeto altere seu comportamento
 * quando seu estado interno muda; ele parece mudar de classe.
 *
 * <p><b>Problema:</b> Switches/ifs grandes baseados em um campo
 * {@code state} que ditam o comportamento de cada método.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Substitui condicionais por polimorfismo.</li>
 *   <li>+ Adicionar novo estado é adicionar nova classe (Open/Closed).</li>
 *   <li>- Mais classes para gerenciar.</li>
 *   <li>- Transições entre estados podem ficar espalhadas.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> máquina de estados trivial (2-3 estados sem
 * comportamento complexo) — {@code enum} com método já basta.
 *
 * <p>Relacionado a <i>Strategy</i>: estrutura praticamente idêntica, mas a
 * intenção é diferente — State troca comportamento por mudança de fase do
 * objeto; Strategy troca algoritmo por escolha externa.
 */
package dev.deyve.state;
