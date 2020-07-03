require 'test_helper'

class UserTest < ActiveSupport::TestCase
  def setup
    @user = users(:user1)
  end

  test 'valid user' do
    assert @user.valid?
  end

  test 'invalid without email' do
    @user.email = ''
    refute @user.valid? "user is valid without an email address"
    assert_not_nil @user.errors[:email], 'no validation error for email address present'
  end

  test 'invalid with bad email' do
    @user.email = 'a'
    refute @user.valid? "user is valid with a bad email address"
    assert_not_nil @user.errors[:email], 'no validation error for email address present'
  end

  test 'invalid without password' do
    @user.encrypted_password = ''
    refute @user.valid? "user is valid without a password"
    assert_not_nil @user.errors[:encrypted_password], 'no validation error for password present'
  end
end
