import { Component, Input } from '@angular/core';
import { TaskService } from "go/app/services/task.service";

@Component({
    selector: 'task-list',
    template: '<ul class="list-group" *ngFor="let task of tasks | async"><task [task]="task"></task></ul>'
})
export class TasklistComponent {
    tasks;
    @Input() currentList;

    constructor(
        private taskService: TaskService
    ) {}

    UpdateTasks(list_id) {
        this.tasks = this.taskService.getItems(list_id);
    }
}