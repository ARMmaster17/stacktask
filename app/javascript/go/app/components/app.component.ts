import {Component, ViewChild} from '@angular/core';
import { TasklistComponent } from "go/app/components/tasklist.component";
import {ListSelectorComponent} from "go/app/components/listselector.component";

@Component({
    selector: 'angular-app-container',
    template: '<angular-list-selector #listSelectorComponent (selectedListChanged)="OnListChanged($event)"></angular-list-selector><task-list></task-list>'
})
export class AppContainerComponent {
    currentList;

    @ViewChild(TasklistComponent) private taskList : TasklistComponent;
    @ViewChild(ListSelectorComponent) private listList : ListSelectorComponent;

    OnListChanged($event) {
        this.taskList.currentList = this.listList.selectedList;
        this.taskList.UpdateTasks(this.taskList.currentList);
    }
}