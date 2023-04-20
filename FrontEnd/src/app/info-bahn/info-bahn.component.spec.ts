import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoBahnComponent } from './info-bahn.component';

describe('InfoBahnComponent', () => {
  let component: InfoBahnComponent;
  let fixture: ComponentFixture<InfoBahnComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoBahnComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoBahnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
