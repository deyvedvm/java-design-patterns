# Comparações entre padrões parecidos

A parte mais difícil de estudar padrões é distinguir os que *parecem* iguais. Aqui ficam as quatro confusões mais comuns, com critério prático pra escolher.

---

## Strategy × State

**Estrutura quase idêntica:** um contexto que segura uma referência a uma interface e delega chamadas.

| | Strategy | State |
| --- | --- | --- |
| **Intenção** | Trocar **algoritmo** | Trocar **comportamento conforme a fase do objeto** |
| **Quem troca?** | Cliente externo escolhe (`new ImageStorage(jpeg, bw)`) | Contexto transiciona; o próprio estado pode disparar a próxima transição |
| **Estados se conhecem?** | Geralmente não — são intercambiáveis e independentes | Costumam conhecer (ou pelo menos referenciar) o contexto pra transitar |
| **Pista no código** | `context.setStrategy(s)` chamado uma vez | Mudanças de estado acontecem dentro dos métodos do estado |

Neste repo: `strategy/ImageStorage` recebe `Compressor` + `Filter` por parâmetro — cliente escolhe. `state/Canvas` é setado por fora, sem transições — então estruturalmente está mais perto de Strategy mesmo (a categoria State seria mais clara se `BrushTool` chamasse `canvas.setCurrentTool(new EraserTool())` em algum ponto).

**Regra prática:** se você nunca vê um estado mudando para outro dentro do código do próprio estado, provavelmente é Strategy.

---

## Chain of Responsibility × Decorator

**Ambos encadeiam objetos com a mesma interface, cada um segurando referência ao próximo.**

| | Chain of Responsibility | Decorator |
| --- | --- | --- |
| **Intenção** | **Eleger** quem trata a requisição | **Compor** comportamento, todos os elos participam |
| **Fluxo** | Pode parar no primeiro que decide tratar | Sempre atravessa todos os wrappers |
| **Retorno** | Tipicamente `boolean` ou exceção pra parar | Transforma input/output e segue |

Neste repo:
- `chainofresponsibility/Handler.doHandle()` retorna `boolean` — `true` para o chain. O `Authenticator` pode rejeitar a requisição antes do `Logger` rodar.
- `decorator/DataSourceDecorator` sempre delega ao `wrappee` — encrypt + compress + storage participam todos na escrita e na leitura.

**Regra prática:** se algum elo pode legitimamente "consumir" a requisição e impedir os demais, é CoR. Se a expectativa é todo mundo contribuir, é Decorator.

---

## Mediator × Observer

**Ambos desacoplam comunicação direta entre objetos.**

| | Observer | Mediator |
| --- | --- | --- |
| **Topologia** | 1-para-N broadcast | M-para-N coordenado por um terceiro |
| **Sujeito sabe o que fazer?** | Não — só dispara `notifyObservers()`; cada observer reage como quiser | Sim — o mediator sabe que "X mudou → Y deve fazer Z" |
| **Quem tem regras de negócio?** | Os próprios observers | O mediator |
| **Acoplamento** | Subject sabe que tem observers (abstratos) | Componentes não se conhecem; conhecem o mediator (ou nem isso) |

Neste repo:
- `observer/DataSource.setValue()` → todo observer reage à sua maneira. O `DataSource` não sabe se há um chart ou planilha.
- `mediator/ArticlesDialogBox` orquestra explicitamente: "ao selecionar artigo, preencher título e habilitar botão". A lógica de coordenação vive no mediator.

**Regra prática:** "anyone interested wants to know X mudou" → Observer. "X mudando deve disparar uma coreografia específica entre Y, Z, W" → Mediator.

---

## Template Method × Strategy

**Ambos variam parte de um algoritmo.**

| | Template Method | Strategy |
| --- | --- | --- |
| **Mecanismo** | Herança — base define esqueleto, subclasse preenche hooks | Composição — cliente injeta objeto com o algoritmo |
| **Escolha** | Tempo de compilação (escolha da subclasse) | Tempo de execução (escolha do objeto strategy) |
| **Reaproveitamento** | Esqueleto comum + variações pequenas | Algoritmo inteiro encapsulado e trocável |
| **Acoplamento** | Forte (herança) | Fraco (interface) |

Neste repo:
- `template/Task.execute()` chama `auditTrail.recordTrail()` + `doExecute()` (hook). `TransferMoneyTask` e `GenerateReportTask` só preenchem o hook — esqueleto é fixo na base.
- `strategy/ImageStorage.store(file, compressor, filter)` recebe os algoritmos por parâmetro. Pode mudar a cada chamada.

**Regra prática:**
- Estrutura fixa + 1 ou 2 hooks pequenos → Template Method.
- Algoritmo todo varia + escolha em runtime → Strategy.
- Em dúvida, prefira Strategy (composição > herança).

---

## Tabela-resumo: por onde escolher

| Sintoma | Padrão sugerido |
| --- | --- |
| "Como faço o algoritmo X ser intercambiável?" | Strategy |
| "O objeto se comporta diferente em fases distintas" | State |
| "Várias coisas precisam saber quando X muda" | Observer |
| "Esses componentes conversam demais entre si" | Mediator |
| "Quero adicionar comportamentos opcionais combináveis" | Decorator |
| "Vários handlers possíveis, ordem importa, um trata" | Chain of Responsibility |
| "Algoritmo tem esqueleto fixo com pontos de extensão" | Template Method |
