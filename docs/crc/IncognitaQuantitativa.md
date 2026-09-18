
### CRC-16: IncognitaQuantitativa

* **Tipo:** Value Object
* **Responsabilidades:**
  - Registrar explicitamente qual `PapelQuantitativo` era o desconhecido no problema original curado.
  - Manter essa designação estável mesmo após o cálculo ou preenchimento do valor.
  - Impedir que a incógnita seja inferida apenas pela ausência temporária de um dado.
* **Colaboradores:**
  - `PapelQuantitativo`
