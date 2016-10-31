
###Big O notion

####Log(n)

T(n) = T(n/2) + O(1)

T(n) = T(n/4) + O(1) + O(1)

T(n) = T(n/8) + O(1) + O(1) + O(1)

...

T(n) = T(1) + log(n) * O(1)

####O(n)

T(n) = T(n/2) + O(n)

T(n) = T(n/4) + O(n) + O(n/2)

T(n) = T(n/8) + O(n/4) + O(n/2) + O(n)

...

T(n) = T(1) + O(1) + ...+ O(n/8) + O(n/4) + O(n/2) + O(n)

1 + 2 + 4 + 8 + .. + n

[1] + 1 + 2 + 4 + 8 + .. + n - [1] = 2n - 1

O(2n -1) = O(n)

####O(n*Logn)

T(n) = 2T(n/2) + O(n)

T(n/2) = 2T(n/4)  + O(n/2)

T(n) = 4T(n/4) + 2 * O(n/2) + O(n)

T(n) = 8T(n/8) + 4 * O(n/4) + 2 * O(n/2) + O(n)

...


T(n) = nT(1) + n/2 * O (2) + n/4 * O(4) +.. + O(n)

T(n) = nT(1) + n * (O(2)/2) + n*(O(4)/4) + ... +n*(O((2 ^ logn))/ 2 ^ logn)

T(n) = n( T(1) + O(2)/2 + O(4)/4 + O(2 ^ logn)/ 2 ^ logn)

T(n) = n * ( 1 + 1 + ...)

T(n) = n * Log n

#### common cases
O(1) very rare

O(Logn)  BinarySearch OR or Beizeng

O(Gen n) 

O(n) most common/high frequency

O(nLogn) sorting mostly likly is used/needed 

O(n^2) array iterator DP

O(n^3) array iterator DP

O(2^n) search related with combination

O(n!) search related with permutation

