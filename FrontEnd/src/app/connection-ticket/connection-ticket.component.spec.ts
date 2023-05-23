import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionTicketComponent } from './connection-ticket.component';

describe('ConnectionTicketComponent', () => {
  let component: ConnectionTicketComponent;
  let fixture: ComponentFixture<ConnectionTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnectionTicketComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConnectionTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
