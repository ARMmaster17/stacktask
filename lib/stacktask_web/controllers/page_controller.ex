defmodule StacktaskWeb.PageController do
  use StacktaskWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end
end
