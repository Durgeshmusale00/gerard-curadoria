
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
