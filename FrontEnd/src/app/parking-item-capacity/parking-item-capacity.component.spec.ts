import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingItemCapacityComponent } from './parking-item-capacity.component';

describe('ParkingItemCapacityComponent', () => {
  let component: ParkingItemCapacityComponent;
  let fixture: ComponentFixture<ParkingItemCapacityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkingItemCapacityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParkingItemCapacityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
