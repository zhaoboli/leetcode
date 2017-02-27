
class NumberIntepretation:

    # We have a coding system from alphabets to numbers where a=1, b=2, ...z=26.
    # You are given a string of digits as an input.
    # Write a function that will compute the number of valid interpretations of the input.
    # f('11') = 2 Actual interpretations: ('aa', 'k')
    # f('111') = 3 Actual interpretations: ('aaa', 'ak', 'ka')
import string

    d = {}
    for i, a in enumerate(string.lowercase):
        d[i + 1] = a

    def interpret(al, path=""):
        results = []
        if len(al) ==0:
            return [path]

        for wi in xrange(1, len(al)+ 1):
            key = al[:wi]
            if key in d:
                results.extend(al[wi:], path + d[key])

        return results