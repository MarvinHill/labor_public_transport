import { Component } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {
  NONE : string = "state_none";
  SUCCESS : string = "state_success";
  FAILURE : string = "state_failure";

  responseState : string = this.NONE;

}
