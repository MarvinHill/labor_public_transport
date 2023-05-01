import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingItemComponent } from './parking-item.component';

describe('ParkingItemComponent', () => {
  let component: ParkingItemComponent;
  let fixture: ComponentFixture<ParkingItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParkingItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParkingItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
