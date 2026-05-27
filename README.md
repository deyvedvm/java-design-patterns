# Java Design Patterns

Repositório de estudo dos padrões de projeto Gang of Four (GoF) implementados em Java 21. Cada padrão fica em seu próprio pacote, é autocontido e possui uma classe `Main` que demonstra o uso na prática.

## Stack

- Java 21
- Maven
- Lombok (`provided`)

## Como executar

Compilar tudo:

```bash
mvn compile
```

Rodar o demo de um padrão específico (`Main` por pacote):

```bash
mvn compile exec:java -Dexec.mainClass=dev.deyve.observer.Main
```

Ou diretamente, após `mvn compile`:

```bash
java -cp target/classes dev.deyve.observer.Main
```

Substitua `observer` pelo pacote do padrão que quer executar.

Rodar os testes:

```bash
mvn test                                # todos os testes
mvn test -Dtest=BrowseHistoryTest       # uma classe específica
```

## Padrões implementados

Todos os padrões abaixo são **comportamentais** (GoF):

| Padrão | Pacote | Demo |
| --- | --- | --- |
| Observer | `dev.deyve.observer` | `DataSource` notifica `SpreadSheet` e `Chart` quando o valor muda |
| Mediator | `dev.deyve.mediator` | `ArticlesDialogBox` coordena `Button`, `ListBox` e `TextBox` |
| Memento | `dev.deyve.memento` | `Editor` salva/restaura estado via `History` |
| State | `dev.deyve.state` | `Canvas` muda comportamento conforme a `Tool` ativa (Brush/Eraser/Selection) |
| Iterator | `dev.deyve.iterator` | `BrowseHistory` expõe um `Iterator` próprio |
| Strategy | `dev.deyve.strategy` | `ImageStorage` combina `Compressor` + `Filter` intercambiáveis |
| Template Method | `dev.deyve.template` | `Task` define o esqueleto; `TransferMoneyTask`/`GenerateReportTask` preenchem os passos |
| Chain of Responsibility | `dev.deyve.chainofresponsibility` | `Authenticator → Logger → Compressor` processam um `HttpRequest` |
| Visitor | `dev.deyve.visitor` | `HtmlDocument` aceita `Operation` (`PlainText`, `Highlight`) sobre seus `HtmlNode` |

## Estrutura

```
src/main/java/dev/deyve/
├── observer/
├── mediator/
├── memento/
├── state/
├── iterator/
├── strategy/
├── template/
├── chainofresponsibility/
└── visitor/
```

Cada pacote segue o mesmo formato:
- Interfaces / classes abstratas com os papéis do padrão
- Implementações concretas
- Uma classe `Main` que monta o cenário e dispara a demonstração

Não há código compartilhado entre os pacotes — cada pasta pode ser lida de forma independente.

## Referências de estudo

- Gamma, Helm, Johnson, Vlissides — *Design Patterns: Elements of Reusable Object-Oriented Software*
- Freeman & Robson — *Head First Design Patterns*
- [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns)

## Autor

Deyve Vieira — [deyve.dev](https://www.deyve.dev/)
