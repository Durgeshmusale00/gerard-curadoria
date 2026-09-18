
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
