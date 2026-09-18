
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
