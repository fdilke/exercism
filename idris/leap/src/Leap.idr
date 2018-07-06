module Leap

export 
isLeap : Int -> Bool
isLeap year =
    if (mod year 400 == 0) then
        True
    else if (mod year 100 == 0) then
        False
    else if (mod year 4 == 0) then
        True
    else
        False

export
version : String
version = "1.0.0"
