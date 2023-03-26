import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoutingTopBarComponent } from './routing-top-bar.component';

describe('RoutingTopBarComponent', () => {
  let component: RoutingTopBarComponent;
  let fixture: ComponentFixture<RoutingTopBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoutingTopBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RoutingTopBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
