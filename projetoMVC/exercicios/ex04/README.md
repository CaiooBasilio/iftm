# README – Galeria de Produtos com Bootstrap 5

## 1. Estrutura da Página

- O código HTML cria uma **galeria de produtos** usando **Bootstrap 5.3**.
- O container principal é `<div class="container mt-4">` para centralizar e dar margem superior.
- Cada linha da galeria é representada por `<div class="row align-items-stretch">`, garantindo que os **cards fiquem alinhados verticalmente**.

## 2. Cards de Produto

Cada produto está dentro de:

```html
<div class="col-6 col-md-4 mb-3">
  <div class="card h-100">
    ...
  </div>
</div>
```

### 🔹 Explicação das classes

- `col-6` → **2 cards por linha em telas pequenas (mobile)**  
- `col-md-4` → **3 cards por linha em telas médias e grandes (desktop)**  
- `mb-3` → **margem inferior** entre os cards  
- `h-100` → faz o card ocupar **100% da altura da coluna**, garantindo **altura uniforme entre todos os cards**  
- `align-items-stretch` (na row) → faz as **colunas esticarem verticalmente**, mantendo os cards alinhados  

## 3. Imagens com Proporção (`ratio`)

- As imagens estão dentro de `<div class="ratio ratio-4x3">`:

```html
<div class="ratio ratio-4x3">
    <img src="img/umavez.webp" class="card-img-top" alt="Blusa do Galo Uma Vez Até Morrer">
</div>
```

- `ratio-4x3` → **mantém proporção 4:3**, evitando que imagens de tamanhos diferentes quebrem o layout do card.
- `card-img-top` → posiciona a imagem no topo do card.

## 4. Card Body

Cada card contém:

```html
<div class="card-body">
    <h5 class="card-title">Nome do Produto</h5>
    <p class="card-text">Descrição do produto.</p>
    <p class="card-title">Preço</p>
    <a href="umaVez.html" target="_blank" class="btn btn-primary">Comprar</a>
</div>
```

- `card-body` → área de conteúdo do card  
- `card-title` → título do produto ou preço  
- `card-text` → descrição  
- `btn btn-primary` → botão estilizado pelo Bootstrap, direcionando para a página do produto  

## 5. Responsividade

- **Mobile (<768px)** → 2x2 cards (`col-6`)  
- **Desktop (≥768px)** → 3x3 cards (`col-md-4`)  
- Todos os cards têm **altura uniforme** graças a `h-100` e `align-items-stretch`.  
- Imagens mantêm proporção consistente com `ratio`.

## 6. Considerações

- Essa galeria é **totalmente responsiva** e se adapta a diferentes tamanhos de tela.  
- Você pode alterar a proporção das imagens (ex.: `ratio-1x1`, `ratio-16x9`) para outros formatos de layout.  
- Para adicionar novos produtos, basta **copiar a estrutura da coluna (`col-6 col-md-4`)** dentro da row.  

## 7. Observações

- É recomendável usar **imagens do mesmo tamanho** para que a proporção fique uniforme e o layout mais bonito.  
- Botões e títulos seguem os estilos padrão do Bootstrap, podendo ser customizados com cores ou classes adicionais.

