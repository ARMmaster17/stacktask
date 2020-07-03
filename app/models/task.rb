class Task < ApplicationRecord
  belongs_to :list

  validates :name, length: { in: 1..255 }, presence: true
  validates :list, presence: true
end
