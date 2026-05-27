/**
 * <h2>Prototype (Criacional)</h2>
 *
 * <p><b>Intenção:</b> Criar novos objetos copiando uma instância existente
 * (o protótipo), em vez de instanciar do zero.
 *
 * <p><b>Problema:</b> Criar instâncias é caro (I/O, cálculo, configuração)
 * ou complexo, e o cliente não deve depender da classe concreta.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Evita repetir lógica de inicialização cara.</li>
 *   <li>+ Cliente clona via interface, sem conhecer o tipo concreto.</li>
 *   <li>- Cópia rasa vs profunda exige cuidado com referências aninhadas.</li>
 *   <li>- {@code Cloneable} do Java é considerado quebrado (Bloch,
 *       <i>Effective Java</i>) — prefira <i>copy constructor</i>.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> objetos baratos de criar, com poucos campos.
 */
package dev.deyve.prototype;
