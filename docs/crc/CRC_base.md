# Cartões CRC — Curador de Histórias Aditivas
Modelagem de Objetos Semanticamente Ricos a partir de Situações Aditivas

Este documento consolida todos os 20 cartões CRC (Classe, Responsabilidades, Colaboradores) do sistema, organizados por pacotes arquiteturais de acordo com o modelo de domínio do projeto.

---

## 1. Núcleo Quantitativo (`dominio.quantitativo`)

### CRC-01: Numero
* **Tipo:** Value Object (Imutável)
* **Responsabilidades:**
  - Encapsular um valor numérico inteiro primitivo.
  - Executar operações aritméticas básicas do domínio aditivo (`somar`, `subtrair`).
  - Indicar propriedades do valor (`ehNegativo`, `ehZero`, `ehPositivo`).
  - Proteger o invariante de representação numérica semântica.
* **Colaboradores:**
  - Nenhum (classe atômica fundamental).

---

### CRC-02: FamiliaObjeto
* **Tipo:** Entidade Conceitual / Identificador Semântico
* **Responsabilidades:**
  - Definir a identidade conceitual comum a variações de um mesmo item (ex.: "rosa", "figurinha", "boneca").
  - Fornecer critério de agrupamento semântico para totalização no inventário.
  - Prover identificador único (`id`) e nome legível (`nomeExibicao`).
* **Colaboradores:**
  - Nenhum.

---

### CRC-03: CaracteristicaObjeto
* **Tipo:** Value Object
* **Responsabilidades:**
  - Representar propriedades semânticas distintivas (ex.: tipo="cor", valor="branca"; tipo="material", valor="madeira").
  - Evitar a proliferação de subclasses rígidas para diferenciar variações do mesmo objeto.
  - Comparar igualdade por tipo e valor de característica.
* **Colaboradores:**
  - Nenhum.

---

### CRC-04: ObjetoContado
* **Tipo:** Entidade de Domínio
* **Responsabilidades:**
  - Representar a identidade precisa daquilo que está sendo quantificado.
  - Associar uma `FamiliaObjeto` a um conjunto de `CaracteristicaObjeto`.
  - Determinar se pertence à mesma família de outro `ObjetoContado`.
  - Atuar como fábrica de `Quantidade` associada a si mesmo (`quantificar(Numero, Grandeza, Unidade)`).
* **Colaboradores:**
  - `FamiliaObjeto`
  - `CaracteristicaObjeto`
  - `Quantidade`
  - `Numero`
  - `GrandezaQuantitativa`
  - `UnidadeMedida`

---

### CRC-05: GrandezaQuantitativa
* **Tipo:** Enumeração / Vocabulário Fechado
* **Responsabilidades:**
  - Definir a natureza da grandeza matemática envolvida (ex.: `CONTAGEM`, `VALOR_MONETARIO`, `MASSA`).
  - Garantir compatibilidade conceitual em operações aritméticas.
* **Colaboradores:**
  - Nenhum.

---

### CRC-06: UnidadeMedida
* **Tipo:** Enumeração / Vocabulário Fechado
* **Responsabilidades:**
  - Representar a unidade física ou de contagem da grandeza (ex.: `UNIDADE`, `REAL`, `CENTAVO`, `QUILOGRAMA`).
  - Validar se a unidade é compatível com a `GrandezaQuantitativa` informada.
* **Colaboradores:**
  - `GrandezaQuantitativa`

---

### CRC-07: Quantidade
* **Tipo:** Value Object Rico (Imutável)
* **Responsabilidades:**
  - Associar `Numero`, `ObjetoContado`, `GrandezaQuantitativa` e `UnidadeMedida`.
  - Exigir compatibilidade estrita antes de somar ou subtrair (mesmo objeto/família, mesma grandeza e mesma unidade).
  - Recusar subtrações que resultem em valor numérico negativo (proteger invariante).
  - Produzir novas instâncias de `Quantidade` resultantes de operações aritméticas.
* **Colaboradores:**
  - `Numero`
  - `ObjetoContado`
  - `GrandezaQuantitativa`
  - `UnidadeMedida`

---

## 2. Núcleo Narrativo e Estados (`dominio.narrativo`)

### CRC-08: ParticipanteNarrativo
* **Tipo:** Entidade
* **Responsabilidades:**
  - Representar a identidade estável e o nome de uma pessoa, grupo ou entidade na história (ex.: "Vovó", "Netinha").
  - Servir como referência para possuidores de inventário, atores e destinatários.
  - Não assumir papel estático (pode ser ator em um momento e destinatário em outro).
* **Colaboradores:**
  - Nenhum.

---

### CRC-09: Inventario
* **Tipo:** Entidade / Coleção Rica
* **Responsabilidades:**
  - Manter o conjunto de `Quantidade`s possuídas por um participante.
  - Adicionar quantidades compatíveis ao saldo existente.
  - Retirar quantidades específicas, validando suficiência prévia e impedindo inconsistência de estado.
  - Totalizar quantidades de objetos que pertençam à mesma `FamiliaObjeto`.
  - Fornecer visão imutável ou cópia defensiva do seu estado atual.
* **Colaboradores:**
  - `Quantidade`
  - `ObjetoContado`
  - `FamiliaObjeto`
  - `Numero`

---

### CRC-10: EstadoDePosse
* **Tipo:** Value Object / Snapshot
* **Responsabilidades:**
  - Representar o retrato instantâneo (fotografia) do inventário de um participante em um momento específico do tempo.
  - Associar um `ParticipanteNarrativo` ao estado do seu `Inventario`.
  - Garantir imutabilidade do registro temporal daquele participante.
* **Colaboradores:**
  - `ParticipanteNarrativo`
  - `Inventario`

---

### CRC-11: AcaoNarrativa
* **Tipo:** Objeto Semântico / Value Object
* **Responsabilidades:**
  - Representar o significado curado da ação (ex.: "doar", "perder", "receber", "comprar").
  - Identificar o sentido quantitativo do efeito nos estados dos participantes (acréscimo ou decréscimo).
  - Conectar ator e destinatário da ação no domínio semântico.
* **Colaboradores:**
  - `ParticipanteNarrativo`

---

### CRC-12: MarcadorTemporal
* **Tipo:** Value Object
* **Responsabilidades:**
  - Preservar a referência temporal explícita do enunciado (ex.: ordem 1, "ontem", "hoje", "primeira partida").
  - Estabelecer a ordenação cronológica das transformações narrativas sem depender da posição de campos visuais.
* **Colaboradores:**
  - Nenhum.

---

### CRC-13: ContextoNarrativo
* **Tipo:** Value Object
* **Responsabilidades:**
  - Guardar a ambientação e metadados contextuais da situação (ex.: local, ocasião, cenário).
  - Fornecer referências abstratas para contextualizar a narrativa e apoiar a camada de representação.
* **Colaboradores:**
  - Nenhum.

---

### CRC-14: TransformacaoNarrativa
* **Tipo:** Entidade de Transição de Estado
* **Responsabilidades:**
  - Representar uma alteração discreta e ordenada entre estados de posse.
  - Vincular `MarcadorTemporal`, `AcaoNarrativa`, participante de origem (ator), participante de destino e `Quantidade` transferida.
  - Aplicar o efeito da transformação sobre os inventários envolvidos.
* **Colaboradores:**
  - `MarcadorTemporal`
  - `AcaoNarrativa`
  - `ParticipanteNarrativo`
  - `Quantidade`
  - `Inventario`

---

## 3. Estrutura Matemática e Validação (`dominio.estrutural` e `dominio.validacao`)

### CRC-15: PapelQuantitativo
* **Tipo:** Enumeração / Identificador Semântico de Papel
* **Responsabilidades:**
  - Designar formalmente a função exercida por uma quantidade na equação aditiva (ex.: `ESTADO_INICIAL`, `TRANSFORMACAO_1`, `TRANSFORMACAO_2`, `ESTADO_FINAL_RESULTANTE`, `PARTE`, `TODO`, `REFERIDO`, `REFERENDO`).
  - Servir de âncora para a incógnita semântica.
* **Colaboradores:**
  - Nenhum.

---

### CRC-16: IncognitaQuantitativa
* **Tipo:** Value Object
* **Responsabilidades:**
  - Registrar explicitamente qual `PapelQuantitativo` era o desconhecido no problema original curado.
  - Manter essa designação estável mesmo após o cálculo ou preenchimento do valor.
  - Impedir que a incógnita seja inferida apenas pela ausência temporária de um dado.
* **Colaboradores:**
  - `PapelQuantitativo`

---

### CRC-17: RelacaoEstrutural
* **Tipo:** Serviço de Domínio / Regra Algébrica
* **Responsabilidades:**
  - Coordenar a relação matemática entre múltiplos papéis aditivos (ex.: composição de transformações: $E_{inicial} - T_1 - T_2 = E_{final}$).
  - Validar a coerência aritmética entre os valores atribuídos a cada papel.
  - Calcular o valor algébrico correspondente ao papel da incógnita.
  - Verificar a compatibilidade global de grandezas e unidades entre todos os termos da relação.
* **Colaboradores:**
  - `PapelQuantitativo`
  - `Quantidade`
  - `ResultadoValidacao`

---

### CRC-18: ResultadoValidacao
* **Tipo:** Value Object / Diagnóstico Estruturado
* **Responsabilidades:**
  - Acumular diagnósticos estruturados de violação de invariantes ou divergências de curadoria.
  - Informar se o modelo está consistente (`ehValido()`).
  - Disponibilizar lista descritiva e tipada de erros (ex.: ator ausente, quantidade insuficiente, divergência aritmética) sem sobrescrever os dados curados.
* **Colaboradores:**
  - Nenhum (ou classe auxiliar interna `Diagnostico`).

---

### CRC-19: SituacaoProblema
* **Tipo:** Agregado Raiz (Aggregate Root)
* **Responsabilidades:**
  - Coordenar todos os elementos da situação curada (participantes, catálogo de objetos, estado inicial, transformações, incógnita e estado final curado).
  - Disparar validação global de coerência estrutural e aritmética gerando `ResultadoValidacao`.
  - Projetar o modelo de domínio na forma de uma `SequenciaNarrativa` neutra e desacoplada de apresentação.
* **Colaboradores:**
  - `ParticipanteNarrativo`
  - `ObjetoContado`
  - `EstadoDePosse`
  - `TransformacaoNarrativa`
  - `RelacaoEstrutural`
  - `IncognitaQuantitativa`
  - `ResultadoValidacao`
  - `SequenciaNarrativa`

---

## 4. Representação e Quadrinhos (`representacao`)

### CRC-20: SequenciaNarrativa
* **Tipo:** Modelo Intermediário de Domínio/Representação
* **Responsabilidades:**
  - Representar a sequência cronológica abstrata e independente de mídia dos acontecimentos da história.
  - Estruturar os passos em tipos semânticos: `ESTADO`, `EVENTO` (ou ação) e `PERGUNTA` (baseada na incógnita).
  - Conservar referências aos objetos semânticos originais sem formatar texto ou desenho.
* **Colaboradores:**
  - `EstadoDePosse`
  - `TransformacaoNarrativa`
  - `IncognitaQuantitativa`

---

### CRC-21: GeradorRoteiroQuadrinhos
* **Tipo:** Serviço de Representação
* **Responsabilidades:**
  - Receber uma `SequenciaNarrativa` e convertê-la em uma estrutura de roteiro de quadrinhos (`RoteiroQuadrinhos`).
  - Mapear estados e eventos em `Quadro`s (quadro inicial, ações intermediárias e quadro final com balão de pergunta).
  - Aplicar regras de apresentação de cena, personagens presentes, legendas e balões sem recalcular matemática.
* **Colaboradores:**
  - `SequenciaNarrativa`
  - `RoteiroQuadrinhos`
  - `Quadro`
