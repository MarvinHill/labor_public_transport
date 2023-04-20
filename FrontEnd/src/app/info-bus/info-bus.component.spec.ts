import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoBusComponent } from './info-bus.component';

describe('InfoBusComponent', () => {
  let component: InfoBusComponent;
  let fixture: ComponentFixture<InfoBusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoBusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoBusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
