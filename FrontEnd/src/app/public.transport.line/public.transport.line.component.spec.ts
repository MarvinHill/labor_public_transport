import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicTransportLineComponent } from './public.transport.line.component';

describe('PublicTransportLineComponent', () => {
  let component: PublicTransportLineComponent;
  let fixture: ComponentFixture<PublicTransportLineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublicTransportLineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicTransportLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
