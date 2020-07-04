import {Component, OnInit, Output, ViewChild} from '@angular/core';
import { ListService } from "go/app/services/list.service";
import { EventEmitter } from "@angular/core";
import {TasklistComponent} from "go/app/components/tasklist.component";

@Component({
  selector: 'angular-list-selector',
  template: '<select #t (change)="UpdateCurrentList(t.value)"><option *ngFor="let x of lists | async" [value]="x.id">{{x.name}}</option></select>'
})

export class ListSelectorComponent implements OnInit {
    lists;
    currentItem;
    @Output() selectedListChanged = new EventEmitter<any>();
    @Output() selectedList: { id: number, name: string };

    constructor(
        private listService: ListService
    ) {}

    ngOnInit(): void {
        this.lists = this.listService.getItems();
    }

    UpdateCurrentList(item) {
        this.selectedList = item;
        this.selectedListChanged.emit();
    }

    GetCurrentlySelectedList() {
        return this.selectedList;
    }
}
