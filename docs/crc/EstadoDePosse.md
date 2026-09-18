
### CRC-10: EstadoDePosse

* **Tipo:** Value Object / Snapshot
* **Responsabilidades:**
  - Representar o retrato instantâneo (fotografia) do inventário de um participante em um momento específico do tempo.
  - Associar um `ParticipanteNarrativo` ao estado do seu `Inventario`.
  - Garantir imutabilidade do registro temporal daquele participante.
* **Colaboradores:**
  - `ParticipanteNarrativo`
  - `Inventario`
