module Hamming

import Data.Vect

public export
data Nucleotide = A | C | G | T

public export
implementation Eq Nucleotide where
    A == A = True
    C == C = True
    G == G = True
    T == T = True
    _ == _ = False

export
hamming_distance : Eq a => Vect n a -> Vect n a -> Nat
hamming_distance Nil Nil = 0
hamming_distance (x1 :: rest1) (x2 :: rest2) =
    (if (x1 == x2) then 0 else 1) +
        hamming_distance rest1 rest2

export
version : String
version = "1.0.0"
