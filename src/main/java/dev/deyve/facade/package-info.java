/**
 * <h2>Facade (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Fornecer uma interface unificada e simplificada para
 * um conjunto de interfaces de um subsistema complexo.
 *
 * <p><b>Problema:</b> Cliente precisa orquestrar várias chamadas em ordem
 * específica entre módulos de baixo nível. Esse conhecimento vaza pra
 * cada lugar que usa o subsistema.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Isola o cliente da complexidade do subsistema.</li>
 *   <li>+ Reduz acoplamento — cliente depende só do facade.</li>
 *   <li>- Facade pode crescer e virar um <i>God Object</i> que sabe demais.</li>
 *   <li>- Esconder demais pode dificultar uso avançado do subsistema.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> subsistema simples (1-2 classes) — facade
 * vira camada vazia.
 */
package dev.deyve.facade;
