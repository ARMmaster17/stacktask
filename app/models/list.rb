class List < ApplicationRecord
  belongs_to :user

  has_many :tasks, dependent: :destroy

  validates :name, length: { in: 1..255 }, presence: true
  validates :user, presence: true
end
