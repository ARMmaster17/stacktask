require 'test_helper'

class ListTest < ActiveSupport::TestCase
  test 'valid list' do
    valid_list = List.new(lists(:list1))
    assert valid_list.valid?
  end

  test 'invalid without name' do
    invalid_list = List.new(lists(:list_no_name))
    refute invalid_list.valid? 'list is valid without a name'
    assert_not_nil invalid_list.errors[:name], 'no validation error for no name present'
  end

  test 'invalid with long name' do
    invalid_list = List.new(lists(:list_long_name))
    refute invalid_list.valid? 'list is valid with a long name'
    assert_not_nil invalid_list.errors[:name], 'no validation error for long name'
  end
end
