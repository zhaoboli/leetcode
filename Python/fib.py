class Fib:
    def Fib(self, n):
        if n == 0 or n == 1:
            return 1
        return Fib(n - 1) + Fib(n - 2)

