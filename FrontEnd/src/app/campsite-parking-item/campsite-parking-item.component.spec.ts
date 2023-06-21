import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampsiteParkingItemComponent } from './campsite-parking-item.component';

describe('CampsiteParkingItemComponent', () => {
  let component: CampsiteParkingItemComponent;
  let fixture: ComponentFixture<CampsiteParkingItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CampsiteParkingItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CampsiteParkingItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
