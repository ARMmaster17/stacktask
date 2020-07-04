import {Component, Input} from "@angular/core";

@Component({
    selector: 'task',
    template: '<li class="list-group-item">{{task.name}}</li>'
})
export class TaskComponent {
    @Input() task;
}