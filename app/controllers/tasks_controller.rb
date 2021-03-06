class TasksController < ApplicationController
  before_action :set_task, only: [:show, :edit, :update, :destroy]
  before_action :set_list
  before_action :authenticate_user!

  # GET /tasks
  # GET /tasks.json
  def index
    @tasks = @list.tasks
  end

  # GET /tasks/1
  # GET /tasks/1.json
  def show
  end

  # GET /tasks/new
  def new
    @task = @list.tasks.new
  end

  # GET /tasks/1/edit
  def edit
    @task = @list.tasks.find(params[:id])
  end

  # POST /tasks
  # POST /tasks.json
  def create
    @task = @list.tasks.new(task_params)

    respond_to do |format|
      if @task.save
        format.html { redirect_to list_task_path(@list, @task), notice: 'Task was successfully created.' }
        format.json { render :show, status: :created, location: @task }
      else
        format.html { render :new }
        format.json { render json: @task.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /tasks/1
  # PATCH/PUT /tasks/1.json
  def update
    respond_to do |format|
      if @task.update(task_params)
        format.html { redirect_to list_task_path(@list, @task), notice: 'Task was successfully updated.' }
        format.json { render :show, status: :ok, location: @task }
      else
        format.html { render :edit }
        format.json { render json: @task.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /tasks/1
  # DELETE /tasks/1.json
  def destroy
    @task.destroy
    respond_to do |format|
      format.html { redirect_to list_tasks_url(@list), notice: 'Task was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_task
      @task = Task.find(params[:id])
    end

  def set_list
    @list = List.find(params[:list_id])
  end

    # Only allow a list of trusted parameters through.
    def task_params
      params.require(:task).permit(:list_id, :name)
    end
end
