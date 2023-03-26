import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddShuttleLineComponent } from './add-shuttle-line.component';

describe('AddShuttleLineComponent', () => {
  let component: AddShuttleLineComponent;
  let fixture: ComponentFixture<AddShuttleLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddShuttleLineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddShuttleLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
