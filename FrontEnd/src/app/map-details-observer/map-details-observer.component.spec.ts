import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapDetailsObserverComponent } from './map-details-observer.component';

describe('MapDetailsObserverComponent', () => {
  let component: MapDetailsObserverComponent;
  let fixture: ComponentFixture<MapDetailsObserverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MapDetailsObserverComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MapDetailsObserverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
