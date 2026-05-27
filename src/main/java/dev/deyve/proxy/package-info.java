/**
 * <h2>Proxy (Estrutural)</h2>
 *
 * <p><b>Intenção:</b> Fornecer um <i>substituto</i> ou marcador para outro
 * objeto, controlando o acesso a ele.
 *
 * <p><b>Problema:</b> Você quer adicionar controle de acesso, lazy loading,
 * cache, logging ou contagem de referências a um objeto, sem alterar seu
 * código nem o do cliente.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ Cliente nem percebe — proxy implementa a mesma interface.</li>
 *   <li>+ Várias variantes: <i>virtual proxy</i> (lazy), <i>protection
 *       proxy</i> (auth), <i>remote proxy</i> (RPC), <i>caching proxy</i>.</li>
 *   <li>- Mais indireção — pode mascarar custo real de uma chamada.</li>
 *   <li>- Outro lugar para esquecer de invalidar cache.</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> quando o controle adicional não justifica a
 * indireção — chame o objeto direto.
 *
 * <p>Em Java, considere {@link java.lang.reflect.Proxy} ou bibliotecas
 * como CGLIB para criar proxies dinâmicos sem boilerplate.
 */
package dev.deyve.proxy;
