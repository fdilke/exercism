import Data.Vect

mumble: Int -> Int
mumble x = x - 88

humble: (value: Int) -> Int
humble q = q * q

twice: (a -> a) -> (a -> a)
twice f x = f (f x)

my_the: (ty: Type) -> ty -> ty
my_the ty x = x

collatz_iterate: Int -> Int
collatz_iterate n = if (mod n 2 == 0) then (div n 2) else (3 * n + 1)

collatz_iterations: Int -> Int -> Int
collatz_iterations n acc = if (n == 1) then acc else (collatz_iterations (collatz_iterate n) (acc+1))

double2: Num ty => ty -> ty
double2 x = x + x

longer: String -> String -> Nat
longer a b
    = let len1 = length a
          len2 = length b in
            if (len1 > len2) then len1 else len2

pythagoras: Double -> Double -> Double
pythagoras x y =
    sqrt(square x + square y) where
        square: Double -> Double
        square u = u * u

data Rubbish = A | B | C
