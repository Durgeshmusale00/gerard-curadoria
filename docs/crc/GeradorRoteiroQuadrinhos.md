## CRC-21: GeradorRoteiroQuadrinhos

* **Tipo:** Serviço de Representação
* **Responsabilidades:**
  - Receber uma `SequenciaNarrativa` e convertê-la em uma estrutura de roteiro de quadrinhos (`RoteiroQuadrinhos`).
  - Mapear estados e eventos em `Quadro`s (quadro inicial, ações intermediárias e quadro final com balão de pergunta).
  - Aplicar regras de apresentação de cena, personagens presentes, legendas e balões sem recalcular matemática.
* **Colaboradores:**
  - `SequenciaNarrativa`
  - `RoteiroQuadrinhos`
  - `Quadro`
