
# 2. Deque Dinâmico (Lista Duplamente Encadeada não Circular)

## 2.1. Definição e regra básica
Um **deque (double-ended queue)** dinâmico é uma fila que permite operações de inserção e remoção em ambas as extremidades — frente (head) e fundo/cauda (tail). Implementado como lista duplamente encadeada, cada nó tem `proximo` e `anterior`. Nesta versão específica, a lista não é circular: o `proximo` do último é `null` e o `anterior` do primeiro é `null`.

## 2.2. Invariantes essenciais
- Se a estrutura estiver vazia: `primeiro == null`, `ultimo == null`, `tamanho == 0`.
- Para um nó interno `N`: `N.getProximo().getAnterior() == N` e `N.getAnterior().getProximo() == N` (quando ponteiros não são `null`).

## 2.3. Operações e complexidade
- `addInicio` / `addFinal` (push front / push back): **O(1)**.
- `removeInicio` / `removeFinal` (pop front / pop back): **O(1)**.
- `peekInicio` / `peekFinal`: **O(1)**.
- Acesso por índice ou remoção em posição arbitrária: **O(n)**.

A capacidade do deque de operar em ambas extremidades em tempo constante é sua característica definidora.

## 2.4. Características específicas e justificativas
- **Acesso em ambas as extremidades em O(1)**: a presença de `primeiro` e `ultimo` facilita operações rápidas sem necessidade de percorrer a lista.

- **Não circularidade**: torna a estrutura mais simples para usos onde não faz sentido "dar a volta" automaticamente. Por exemplo, quando `null` marca o fim da estrutura e permite checagens explícitas de término.

- **Flexibilidade**: um deque pode ser usado tanto como fila quanto como pilha (stack) — basta escolher as operações de inserção/remoção apropriadas.

- **Overhead de memória**: como na lista duplamente encadeada, cada nó armazena dois ponteiros.

## 2.5. Vantagens
- Extremamente flexível: serve como fila, fila com prioridades simples, pilha dupla.
- Operações críticas são O(1) sem realocação de blocos contíguos (ao contrário de implementações baseadas em arrays quando cheias).
- Implementação dinâmica (sem tamanho fixo): cresce conforme necessário.

## 2.6. Desvantagens
- Não é tão cache-friendly quanto um `ArrayDeque` (implementação baseada em array circular) — múltiplas alocações de nós dispersam-se na heap.
- Overhead por nó.
- Não oferece acesso aleatório eficiente.

## 2.7. Aplicações e exemplos práticos
- **Algoritmos de grafos**: `deque` é utilizado em algoritmos de pesquisa (por exemplo, em algumas variantes do BFS ou 0-1 BFS onde são usadas operações push-front e push-back para pesos 0/1).
- **Janela deslizante (sliding window)**: algoritmos que mantêm máximos/mínimos em uma janela fixa (monotonic deque) usam operações front/back para atualizar a janela eficientemente em O(n).
- **Undo/Redo**: é possível modelar operações de `undo` e `redo` usando uma combinação de pilhas ou um deque para navegar nas operações recentes.
- **Buffers de mensagens**: filas que aceitam inserção em ambas extremidades (por exemplo, LIFO para prioridades recentes ou FIFO para processamento normal).
- **Implementar outras estruturas**: pilha (usar só frente) ou fila (usar frente + fundo).

---

# 3. Comparações e quando usar cada uma

## 3.1. Lista Circular Duplamente Encadeada vs Deque Dinâmico
- **Semântica**: a lista circular é ideal quando a natureza dos dados é cíclica (round-robin, playlist). O deque é orientado a operações por extremidade e não rotaciona automaticamente.

- **Complexidade**: ambos têm O(1) para operações nas extremidades quando implementados como listas duplamente encadeadas.

- **Implementação**: a circularidade requer cuidado extra com invariantes (evitar loops infinitos); o deque (não circular) tem checagens `null` nas extremidades, o que simplifica alguns casos.

- **Uso prático**: escolha circular quando precisar de rotação natural e sem condições de término explícitas; escolha deque quando desejar uma estrutura de fila/pilha flexível e mais direta.

## 3.2. Deque ligado (lista) vs Deque baseado em array (ArrayDeque)
- **ArrayDeque** (buffer circular em array) é geralmente mais eficiente em termos de CPU e cache — ótimo para casos onde o tamanho máximo é previsível ou o padrão de uso é intensivo e contíguo.
- **Deque dinâmico ligado** evita realocações e cópias quando cresce, mas tem maior overhead de ponteiros e pior localidade de memória. Em Java, `ArrayDeque` costuma ser preferido para uso geral por ser mais rápido.
