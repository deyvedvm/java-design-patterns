/**
 * <h2>Factory Method (Criacional)</h2>
 *
 * <p><b>Intenção:</b> Definir uma interface para criar um objeto, mas deixar
 * subclasses decidirem qual classe instanciar.
 *
 * <p><b>Problema:</b> O tipo concreto a ser criado não é conhecido pelo
 * código que dispara a criação — depende de configuração, contexto, ou
 * subclasse escolhida.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Desacopla o cliente das classes concretas.</li>
 *   <li>+ Centraliza a lógica de criação (Single Responsibility).</li>
 *   <li>- Cria uma hierarquia paralela de fábricas para cada hierarquia
 *       de produto.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> quando uma simples função estática
 * {@code of(...)}/{@code valueOf(...)} ou {@code switch} resolve. Não
 * generalize antes da hora.
 */
package dev.deyve.factorymethod;
