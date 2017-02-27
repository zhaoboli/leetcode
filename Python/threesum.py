# Time:  O(n^2)
# Space: O(1)
#
# Given an array S of n integers,
# are there elements a, b, c in S such that a + b + c = 0?
# Find all unique triplets in the array which gives the sum of zero.
#
# Note:
# Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
# The solution set must not contain duplicate triplets.
#    For example, given array S = {-1 0 1 2 -1 -4},
#
#    A solution set is:
#    (-1, 0, 1)
#    (-1, -1, 2)
#


class ThreeSum:

    def three_sum(self, arr_integer):
        _len = len(arr_integer)
        result = []
        if _len < 3:
            return result
        arr_integer.sort()
        i = 0
        while i < (_len - 2):
            if i != 0 and arr_integer[i] == arr_integer[i - 1]:
                i += 1
                continue
            left = i + 1
            right = _len - 1
            while left < right:
                if left - i > 1 and arr_integer[left] == arr_integer[left - 1]:
                    left += 1
                    continue
                if _len - right > 1 and arr_integer[right] == arr_integer[right + 1]:
                    right -= 1
                    continue
                _set = []
                sum_nums = arr_integer[i] + arr_integer[left] + arr_integer[right]
                if sum_nums < 0:
                    left += 1
                elif sum_nums > 0:
                    right -= 1
                else:
                    _set.append(arr_integer[i])
                    _set.append(arr_integer[left])
                    _set.append(arr_integer[right])
                    result.append(_set)
                    left += 1
            i += 1
        return result
