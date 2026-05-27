/**
 * <h2>Builder (Criacional)</h2>
 *
 * <p><b>Intenção:</b> Separar a construção de um objeto complexo da sua
 * representação, permitindo montar o mesmo passo a passo.
 *
 * <p><b>Problema:</b> Construtores com muitos parâmetros (alguns opcionais),
 * <i>telescoping constructors</i>, ou necessidade de validar/configurar
 * antes de chamar {@code build()}.
 *
 * <p><b>Trade-offs:</b>
 * <ul>
 *   <li>+ API fluente, fácil de ler.</li>
 *   <li>+ Permite objeto final imutável.</li>
 *   <li>- Boilerplate extra (mitigado com Lombok {@code @Builder}).</li>
 * </ul>
 *
 * <p><b>Quando NÃO usar:</b> objetos com poucos parâmetros (até ~4) e sem
 * opcionais — um construtor simples basta.
 */
package dev.deyve.builder;
