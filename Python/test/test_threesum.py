import threesum

three_sum_obj = threesum.ThreeSum()


def test_3sum_invalid_input():
    assert three_sum_obj.three_sum([1, 2]) == []


def test_3sum_valid_input():
    assert three_sum_obj.three_sum([-1, 0, 1, 2, -1, -4]) == [[-1, -1, 2], [-1, 0, 1]]

def test_3sum_valid_intput():
    for _item in three_sum_obj.three_sum([-5, -2, -1, -1, 0, 1, 1, 1, 2, 3, 4, 5, 6]):
        print _item
    assert three_sum_obj.three_sum([-5, -2, -1, -1, 0, 1, 1, 1, 2, 3, 4, 5, 6]) == \
           [[-5, -1, 6], [-5, 0, 5], [-5, 1, 4], [-5, 2, 3], [-2, -1, 3], [-2, 0, 2], [-2, 1, 1], [-1, -1, 2], [-1, 0, 1]]
