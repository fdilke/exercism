module Accumulate

export
accumulate : (Int -> Int) -> List Int -> List Int
accumulate f xs = map f xs
