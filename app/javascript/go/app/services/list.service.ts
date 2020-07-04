import { Injectable } from "@angular/core";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class ListService {

    constructor(
        private http: HttpClient
    ) {

    }

    getItems() {
        return this.http.get('/lists.json');
    }
}