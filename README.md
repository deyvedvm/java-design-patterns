# Java Design Patterns

[![CI](https://github.com/deyvedvm/java-design-patterns/actions/workflows/ci.yml/badge.svg)](https://github.com/deyvedvm/java-design-patterns/actions/workflows/ci.yml)

Repositório de estudo dos padrões de projeto Gang of Four (GoF) implementados em Java 21. Cada padrão fica em seu próprio pacote, é autocontido e tem uma classe de teste JUnit que faz o papel de demo + verificação de comportamento.

## Stack

- Java 21
- Maven
- JUnit 5

## Como executar

```bash
mvn test                                       # roda todos os padrões (cada teste é o demo)
mvn test -Dtest=DataSourceTest                 # roda um padrão específico
mvn test -Dtest=PizzaBuilderTest#shouldBuildPizzaWithFluentApi   # um cenário só
```

Cada pacote começa com um `package-info.java` resumindo intenção, problema, trade-offs e quando NÃO usar o padrão — leia-o antes do código.

Para estudo visual e comparativo:
- [`DIAGRAMS.md`](DIAGRAMS.md) — diagrama de classe (Mermaid) de cada um dos 23 padrões.
- [`COMPARISONS.md`](COMPARISONS.md) — confusões comuns: Strategy×State, CoR×Decorator, Mediator×Observer, Template×Strategy.

## Padrões implementados

### Criacionais

| Padrão | Pacote | Demo |
| --- | --- | --- |
| Singleton | `dev.deyve.singleton` | `AppConfig.getInstance()` sempre devolve a mesma instância |
| Factory Method | `dev.deyve.factorymethod` | `NotificationFactory` decide entre `EmailNotification`/`SmsNotification` |
| Abstract Factory | `dev.deyve.abstractfactory` | `WindowsFactory`/`MacFactory` produzem famílias de `Button` + `Checkbox` |
| Builder | `dev.deyve.builder` | `Pizza.builder(...)` monta um objeto imutável passo a passo |
| Prototype | `dev.deyve.prototype` | `Circle`/`Rectangle` clonam via copy constructor |

### Estruturais

| Padrão | Pacote | Demo |
| --- | --- | --- |
| Adapter | `dev.deyve.adapter` | `SquarePegAdapter` faz um `SquarePeg` caber num `RoundHole` |
| Bridge | `dev.deyve.bridge` | `RemoteControl` × `Device` (TV/Radio) evoluem independentes |
| Composite | `dev.deyve.composite` | `Folder` agrega `File`/`Folder` sob a mesma interface `FileSystemNode` |
| Decorator | `dev.deyve.decorator` | `EncryptionDecorator` + `CompressionDecorator` empilham sobre `DataSource` |
| Facade | `dev.deyve.facade` | `OrderFacade` orquestra `InventoryService` + `PaymentService` + `ShippingService` |
| Flyweight | `dev.deyve.flyweight` | `TreeTypeFactory` compartilha `TreeType` entre milhares de `Tree` |
| Proxy | `dev.deyve.proxy` | `LazyImageProxy` adia o load do `RealImage` até o primeiro `display()` |

### Comportamentais

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
| Command | `dev.deyve.command` | `RemoteControl` executa `Command` com histórico para `undo` |
| Interpreter | `dev.deyve.interpreter` | AST `AddExpression`/`SubtractExpression`/`NumberExpression` avaliada via `interpret()` |

## Estrutura

```
src/main/java/dev/deyve/
├── singleton/         factorymethod/      abstractfactory/    builder/        prototype/
├── adapter/           bridge/             composite/          decorator/      facade/         flyweight/      proxy/
└── observer/          mediator/           memento/            state/          iterator/       strategy/       template/       chainofresponsibility/      visitor/        command/        interpreter/
```

Cada pacote em `src/main/java` segue o mesmo formato:
- `package-info.java` com intenção, problema, trade-offs e quando NÃO usar
- Interfaces / classes abstratas com os papéis do padrão
- Implementações concretas

Para cada padrão há uma classe correspondente em `src/test/java` que exercita o cenário com asserções JUnit. Não há código compartilhado entre os pacotes — cada pasta pode ser lida de forma independente.

## Referências de estudo

- Gamma, Helm, Johnson, Vlissides — *Design Patterns: Elements of Reusable Object-Oriented Software*
- Freeman & Robson — *Head First Design Patterns*
- [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns)

## Autor

Deyve Vieira — [deyve.dev](https://www.deyve.dev/)
