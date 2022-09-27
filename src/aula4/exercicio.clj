(ns aula4.exercicio
  (:require [aula4.data :as data]))


;; retornar o vetor de clientes a chave `:full-name` adicionada nos mapas de clientes. (full-name deve ser a concatenacao do `:first-name` com o `:last-name`).

(defn full-name
  [first last]
  (str first " " last))

(defn add-full-name
  [mapa full-name]
  (assoc mapa :full-name full-name)
  )

(defn add-full-name-clientes
  [clientes]
  (map #(add-full-name % (full-name (:first-name %) (:last-name %))) clientes)
  )

(add-full-name-clientes data/clients)

;; retornar clientes que tem `:age` maior que 35. Usar tanto `filter` quanto `remove`.


;; retornar um mapa, tendo a chave do item como o id do produto e o valor sendo a quantidade total comprada desse item.


;; retornar um mapa de compras, onde a chave deve ser o id do cliente e o valor deve ser um vetor que contendo todas as compras do cliente.


;; retornar o vetor de clientes com a chave `:purchases`. O valor dessa chave sera um vetor contendo mapas com `:item-id` e `:amount`.
