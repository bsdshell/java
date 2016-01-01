
mess::IO ()
mess = getLine >>= putStrLn 

mess2::IO ()
mess2 = putStrLn "Input Name" 
                    >> getLine 
                    >>= \x-> putStrLn (reverse x) 

main = do
    print "dog"
    mess
    mess2
