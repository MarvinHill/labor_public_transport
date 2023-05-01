import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoBusTextComponent } from './info-bus-text.component';

describe('InfoBusTextComponent', () => {
  let component: InfoBusTextComponent;
  let fixture: ComponentFixture<InfoBusTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoBusTextComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoBusTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
