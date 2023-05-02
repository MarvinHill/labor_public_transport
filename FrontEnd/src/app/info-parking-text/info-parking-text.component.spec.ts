import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoParkingTextComponent } from './info-parking-text.component';

describe('InfoParkingTextComponent', () => {
  let component: InfoParkingTextComponent;
  let fixture: ComponentFixture<InfoParkingTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoParkingTextComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoParkingTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
