import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShuttleMarkerComponent } from './shuttle-marker.component';

describe('ShuttleMarkerComponent', () => {
  let component: ShuttleMarkerComponent;
  let fixture: ComponentFixture<ShuttleMarkerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShuttleMarkerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShuttleMarkerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
