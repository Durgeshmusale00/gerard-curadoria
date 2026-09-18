
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
