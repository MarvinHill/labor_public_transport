import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HaltestelleInfoComponent } from './haltestelle-info.component';

describe('HaltestelleInfoComponent', () => {
  let component: HaltestelleInfoComponent;
  let fixture: ComponentFixture<HaltestelleInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HaltestelleInfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HaltestelleInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
