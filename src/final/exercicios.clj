(ns final.exercicios
  (:require [final.data :as data]
            [clojure.set :as c-set]))


;; Criar funcao que, dado um vetor de clientes, deve atualizar o endereco de um cliente e retorna o vetor de clientes.
;; A funcao deve atualizar o endereco apenas com os valores presentes no mapa do novo endereco.
;; Para saber a posicao do cliente no vetor pode usar (.indexOf <vetor> <elemento>).

(defn atualiza-endereco
  [clientes id-cliente novo-endereco]
  (let [client-found
        (first
          (filter (fn [{:keys [id]}] (= id id-cliente)) clientes))
        client-index (.indexOf clientes client-found)]
    (update-in clientes [client-index :endereco] merge novo-endereco)))

(comment
  (atualiza-endereco data/clientes "5" {:estado "BA"})
  )

;; Criar funcao que recebe o vetor de compras e retorna um mapa de compras, onde a chave deve ser o id do cliente e o valor deve ser um vetor que contendo todas as compras do cliente.

(defn group-by-purchases
  [acc {:keys [id-cliente] :as purchase}]
  (update acc id-cliente #(conj (or % []) (dissoc purchase :id-cliente))))

(defn mapa-quantidades
  [compras]
  (reduce group-by-purchases {} compras))

(comment
  (mapa-quantidades data/compras)
  )

;; Criar funcao que filtra um vetor de clientes pela chave `:estado` do endereco.
(defn clientes-por-estado
  [clientes estado]
  (filter
    (fn
      [cliente]
      (= (get-in cliente [:endereco :estado]) estado))
    clientes))

(comment
  (clientes-por-estado data/clientes "SP")
  (clientes-por-estado data/clientes "BA")
  (clientes-por-estado data/clientes "TT")
  )

;; Criar funcao para retornar um mapa, tendo a chave do item como o id do produto e o valor sendo a quantidade total comprada desse item.
(defn group-by-purchases-amount
  [acc {:keys [id-item quantidade]}]
  (update acc id-item #(+ (or % 0) quantidade)))

(defn mapa-quantidades
  [compras]
  (reduce group-by-purchases-amount {} compras))

(comment
  (mapa-quantidades data/compras)
  )

;; Dado 2 vetores de clientes (clientes e clientes-2), retornar clientes que est�o presentes em ambos os vetores.
(defn clientes-duplicados
  [v-cliente v-cliente-2]
  (let [client-set (set v-cliente)
        client-2-set (set v-cliente-2)]
    (c-set/intersection client-set client-2-set)))

(comment
  (clientes-duplicados data/clientes data/clientes-2)
  )