class List < ApplicationRecord
  belongs_to :user

  has_many :tasks

  validates :name, length: { in: 1..255 }, presence: true
  validates :user, presence: true
end
