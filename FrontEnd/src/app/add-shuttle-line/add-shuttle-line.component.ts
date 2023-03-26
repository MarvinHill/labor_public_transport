import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { DataServiceService } from '../data-service.service';
import { ShuttleLine } from '../ShuttleLine';
import { UserLoginServiceService } from '../user-login-service.service';

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

    const toPost = this.http.post('http://localhost:8080/ptl', line);
    toPost.subscribe(val => {
      this.dataService.update();
    })
  }
}
