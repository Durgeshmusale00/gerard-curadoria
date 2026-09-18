
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
