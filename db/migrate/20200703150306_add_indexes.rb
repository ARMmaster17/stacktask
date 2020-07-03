class AddIndexes < ActiveRecord::Migration[6.0]
  def change
    add_index :lists, :user_id, unique: false
    add_index :tasks, :list_id, unique: false
  end
end
