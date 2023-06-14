import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { ShuttleLine } from '../ShuttleLine';
import { DataServiceService } from '../services/data-service.service';


@Component({
  selector: 'app-add-shuttle-line',
  templateUrl: './add-shuttle-line.component.html',
  styleUrls: ['./add-shuttle-line.component.css']
})
export class AddShuttleLineComponent {
  http: HttpClient;
  lineNumber: FormControl = new FormControl()
  dataService: DataServiceService;

  constructor(http: HttpClient, dataService: DataServiceService) {
    this.http = http;
    this.dataService = dataService;
  }

  onFormSubmit(form: NgForm): void {

    const line: ShuttleLine = new ShuttleLine();
    line.lineDesignator = form.value.lineDesignator;
    line.hasDelay = false;
    line.id = 0;
    line.lineScheduleEntryList = [];
  }
}
