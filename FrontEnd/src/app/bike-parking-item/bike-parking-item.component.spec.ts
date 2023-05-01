import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BikeParkingItemComponent } from './bike-parking-item.component';

describe('BikeParkingItemComponent', () => {
  let component: BikeParkingItemComponent;
  let fixture: ComponentFixture<BikeParkingItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BikeParkingItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BikeParkingItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
