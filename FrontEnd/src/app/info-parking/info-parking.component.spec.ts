import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoParkingComponent } from './info-parking.component';

describe('InfoParkingComponent', () => {
  let component: InfoParkingComponent;
  let fixture: ComponentFixture<InfoParkingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoParkingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoParkingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
