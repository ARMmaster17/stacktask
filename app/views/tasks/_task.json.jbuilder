json.extract! task, :id, :list_id, :name, :created_at, :updated_at
json.url list_task_url(@list, task, format: :json)
