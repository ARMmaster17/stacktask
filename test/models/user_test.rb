require 'test_helper'

class UserTest < ActiveSupport::TestCase
  test 'valid user' do
    valid_user = User.new(users(:user1))
    assert valid_user.valid?
  end

  test 'invalid without email' do
    valid_user = User.new(users(:user_no_email))
    refute valid_user.valid? "user is valid without an email address"
    assert_not_nil valid_user.errors[:email], 'no validation error for email address present'
  end

  test 'invalid with bad email' do
    valid_user = User.new(users(:user_invalid_email))
    refute valid_user.valid? "user is valid with a bad email address"
    assert_not_nil valid_user.errors[:email], 'no validation error for email address present'
  end

  test 'invalid without password' do
    valid_user = User.new(users(:user_no_password))
    refute valid_user.valid? "user is valid without a password"
    assert_not_nil valid_user.errors[:encrypted_password], 'no validation error for password present'
  end
end
