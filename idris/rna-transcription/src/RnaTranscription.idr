module RnaTranscription

import Data.Vect

%access export
%default total

namespace DnaStrand
  public export
  data DnaStrand =
    A | C | G | T

namespace RnaStrand 
  public export
  data RnaStrand=
    A | C | G | U

-- we seriously have to do this??

Eq RnaStrand where
    A == A = True
    C == C = True
    G == G = True
    U == U = True
    _ == _ = False

toRnaSingle : DnaStrand -> RnaStrand
toRnaSingle A = U
toRnaSingle T = A
toRnaSingle C = G
toRnaSingle G = C

toRna : Vect n DnaStrand -> Vect n RnaStrand
toRna vec = map toRnaSingle vec

