require 'test_helper'

class TaskTest < ActiveSupport::TestCase
  test 'valid task' do
    valid_task = Task.new(tasks(:task1))
    assert valid_task.valid?
  end

  test 'invalid without name' do
    invalid_task = Task.new(tasks(:task_no_name))
    refute invalid_task.valid? 'task is valid without a name'
    assert_not_nil invalid_task.errors[:name], 'no validation error for no name present'
  end

  test 'invalid with long name' do
    invalid_task = Task.new(tasks(:task_long_name))
    refute invalid_task.valid? 'task is valid with a long name'
    assert_not_nil invalid_task.errors[:name], 'no validation error for long name'
  end
end
