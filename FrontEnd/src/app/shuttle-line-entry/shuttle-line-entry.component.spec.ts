import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShuttleLineEntryComponent } from './shuttle-line-entry.component';

describe('ShuttleLineEntryComponent', () => {
  let component: ShuttleLineEntryComponent;
  let fixture: ComponentFixture<ShuttleLineEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShuttleLineEntryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShuttleLineEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});