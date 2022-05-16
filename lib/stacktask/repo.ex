defmodule Stacktask.Repo do
  use Ecto.Repo,
    otp_app: :stacktask,
    adapter: Ecto.Adapters.Postgres
end
