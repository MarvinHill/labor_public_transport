import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShuttleViewComponent } from './shuttle-view.component';

describe('ShuttleViewComponent', () => {
  let component: ShuttleViewComponent;
  let fixture: ComponentFixture<ShuttleViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShuttleViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShuttleViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
