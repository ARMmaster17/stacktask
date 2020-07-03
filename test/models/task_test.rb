require 'test_helper'

class TaskTest < ActiveSupport::TestCase
  def setup
    @task = tasks(:task1)
  end

  test 'valid task' do
    assert @task.valid?
  end

  test 'invalid without name' do
    @task.name = ''
    refute @task.valid? 'task is valid without a name'
    assert_not_nil @task.errors[:name], 'no validation error for no name present'
  end

  test 'invalid with long name' do
    @task.name = 'abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij'
    refute @task.valid? 'task is valid with a long name'
    assert_not_nil @task.errors[:name], 'no validation error for long name'
  end
end
