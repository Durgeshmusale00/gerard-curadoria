
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
