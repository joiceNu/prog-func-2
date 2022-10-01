(ns aula2.exercicio
  (:require [aula2.data :as data]))


;; criar um vetor com nome de clientes que conter� todos os clientes
;; de ambas as colec�es do namespace `aula2.data`.
(into data/clientes-lista data/clientes-vetor) ;;retorna lista
(into [] (into data/clientes-lista data/clientes-vetor))


;; adicionar um cliente no vetor `clientes`.
(conj data/clientes-vetor {:first-name         "Renata"
                            :last-name         "Silva"
                            :age                39
                            :last-year-revenue 7000
                            :location           "SP"})

;; retornar o cliente na posic�o `p` do vetor clientes.
(def pega-por-posicao-vet
  [posicao]
(get data/clientes-vetor posicao))


;; retornar o nome do cliente mais novo do vetor `clientes`.
(peek data/clientes-vetor)



;; remover o cliente mais novo do vetor `clientes`.
(pop data/clientes-vetor)

;; retornar o nome do cliente mais antigo do vetor `clientes`.
(-> data/clientes-vetor
    (first)
    :first-name
    )


;; remover o cliente mais antigo do vetor `clientes`.
(rest data/clientes-vetor)


;; remover do vetor `clientes` os clientes com o `last-year-revenue` menor que 50000
;; (dica: usar `remove` ou `filter`, procurar na documentac�o);
(->> data/clientes-vetor
     (remove #(> (get % :last-year-revenue) 50000))
     )

