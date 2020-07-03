require 'test_helper'

class ListTest < ActiveSupport::TestCase
  def setup
    @list = lists(:list1)
  end

  test 'valid list' do
    assert @list.valid?
  end

  test 'invalid without name' do
    @list.name = ''
    refute @list.valid? 'list is valid without a name'
    assert_not_nil @list.errors[:name], 'no validation error for no name present'
  end

  test 'invalid with long name' do
    @list.name = 'abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij'
    refute @list.valid? 'list is valid with a long name'
    assert_not_nil @list.errors[:name], 'no validation error for long name'
  end
end
