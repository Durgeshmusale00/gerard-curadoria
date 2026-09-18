
### CRC-18: ResultadoValidacao

* **Tipo:** Value Object / Diagnóstico Estruturado
* **Responsabilidades:**
  - Acumular diagnósticos estruturados de violação de invariantes ou divergências de curadoria.
  - Informar se o modelo está consistente (`ehValido()`).
  - Disponibilizar lista descritiva e tipada de erros (ex.: ator ausente, quantidade insuficiente, divergência aritmética) sem sobrescrever os dados curados.
* **Colaboradores:**
  - Nenhum (ou classe auxiliar interna `Diagnostico`).
