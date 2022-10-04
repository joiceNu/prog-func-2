(ns aula2.exercicio
  (:require [aula2.data :as data]))


;; criar um vetor com nome de clientes que conterï¿½ todos os clientes
;; de ambas as colecï¿½es do namespace `aula2.data`.
(into data/clientes-lista data/clientes-vetor) ;;retorna lista
(into [] (into data/clientes-lista data/clientes-vetor))


;; adicionar um cliente no vetor `clientes`.
(conj data/clientes-vetor {:first-name         "Renata"
                            :last-name         "Silva"
                            :age                39
                            :last-year-revenue 7000
                            :location           "SP"})

<<<<<<< HEAD
;; retornar o cliente na posicï¿½o `p` do vetor clientes.
(def pega-por-posicao-vet
  [posicao]
(get data/clientes-vetor posicao))

=======
(defn adiciona-cliente
  [clientes novo-cliente]
  (conj clientes novo-cliente))
>>>>>>> master

;; retornar o nome do cliente mais novo do vetor `clientes`.
(peek data/clientes-vetor)



(defn nome-cliente-mais-novo
  [clientes]
  (:first-name (peek clientes)))

;; remover o cliente mais novo do vetor `clientes`.
(pop data/clientes-vetor)

(defn remove-cliente-mais-novo
  [clientes]
  (pop clientes))

;; retornar o nome do cliente mais antigo do vetor `clientes`.
(-> data/clientes-vetor
    (first)
    :first-name
    )


(defn nome-cliente-mais-antigo
  [clientes]
  (:first-name (first clientes)))

;; remover o cliente mais antigo do vetor `clientes`.
(rest data/clientes-vetor)


;; remover do vetor `clientes` os clientes com o `last-year-revenue` menor que 50000
;; (dica: usar `remove` ou `filter`, procurar na documentacï¿½o);
(->> data/clientes-vetor
     (remove #(> (get % :last-year-revenue) 50000))
     )

<<<<<<< HEAD
=======
(defn remove-cliente-mais-novo
  [clientes]
  (rest clientes))

;; retornar o cliente na posicão `p` do vetor clientes.

(defn retorna-cliente-por-indice
  [clientes idx]
  (get clientes idx))


;; remover do vetor `clientes` os clientes com o `last-year-revenue` menor que 50000 (dica: usar `remove` ou `filter`, procurar na documentacão);

(defn filtra-clientes
  [clientes]
  (filter #(>= (:last-year-revenue %) 50000) clientes))


(defn remove-clientes
  [clientes]
  (remove #(< (:last-year-revenue %) 50000) clientes))
>>>>>>> master
