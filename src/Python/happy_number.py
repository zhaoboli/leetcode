class HappyNumber:
    # @return boolean
    def is_happy_number(self, num):
        sum_memo = set()
        while num != 1:
            num = self.next_number(num)
            if num in sum_memo:
                return False
            sum_memo.add(num)
        return True

    def next_number(self, num):
        sum_num= 0
        while num != 0:
            sum_num += (num % 10) ** 2
            num /= 10
        return sum_num

    def happy(self, n):
        past = set()
        while n != 1:
            n = sum(int(i) ** 2 for i in str(n))
            if n in past:
                return False
            past.add(n)
        return True

