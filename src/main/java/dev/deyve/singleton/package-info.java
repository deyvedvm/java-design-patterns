/**
 * <h2>Singleton (Criacional)</h2>
 *
 * <p><b>Intenção:</b> Garantir que uma classe tenha exatamente uma instância
 * e fornecer um ponto global de acesso a ela.
 *
 * <p><b>Problema:</b> Configuração da aplicação, pool de conexões, cache —
 * casos em que múltiplas instâncias causariam inconsistência ou desperdício.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Acesso global controlado e inicialização <i>lazy</i>.</li>
 *   <li>- Estado global compartilhado dificulta testes (mocks/isolamento).</li>
 *   <li>- Em ambiente multi-thread exige cuidado: {@code synchronized},
 *       <i>double-checked locking</i>, <i>holder idiom</i> ou {@code enum}.</li>
 *   <li>- Acopla código cliente a uma classe concreta.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> quando você pode passar a dependência via
 * construtor (injeção de dependência). No design moderno, Singleton é
 * frequentemente um anti-padrão — prefira DI.
 */
package dev.deyve.singleton;
