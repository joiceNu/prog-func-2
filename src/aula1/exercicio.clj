(ns aula1.exercicio
  (:require [aula1.data :as data]))


;; dado o mapa no namespace data.clj, escrever funcoes que:
;; altera a idade do cliente

(defn altera-idade-cliente
  [cliente nova-idade]
  (assoc cliente :idade nova-idade )
  )

(altera-idade-cliente data/cliente 25)

;; remove o endereco do cliente
(defn remove-endereco
  [cliente]
  (dissoc cliente :endereco)
  )

(remove-endereco data/cliente)


;; atualiza o valor de um item de compra
(defn atualizar-valor-item
  [item valor]
  (update item :valor valor))

(atualizar-valor-item (first data/compras) 40)

;; adicionar o vetor de compras no mapa do cliente
(defn add-compra-cliente
  [cliente compras]
  (assoc cliente :compras compras)
  )

(add-compra-cliente data/cliente data/compras)
;; adiciona um novo item de compra

(defn add-item-compra
  [compras item]
  (conj compras item))

(add-item-compra data/compras {:item "bolo" :valor 20})

;; retorna o nome do cliente

(defn retorna-)
