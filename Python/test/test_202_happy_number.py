import pytest

import happy_number

happy_num_obj = happy_number.HappyNumber();


def test_is_happy_number_19():
    assert happy_num_obj.is_happy_number(19) == True;


def test_is_happy_number_1():
    assert happy_num_obj.is_happy_number(1) == True;