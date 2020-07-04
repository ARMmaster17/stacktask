import { Injectable } from "@angular/core";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class TaskService {

    constructor(
        private http: HttpClient
    ) {

    }

    getItems(list_id) {
        return this.http.get('/lists/' + list_id + '/tasks.json');
    }
}