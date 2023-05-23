import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoBahnTextComponent } from './info-bahn-text.component';

describe('InfoBahnTextComponent', () => {
  let component: InfoBahnTextComponent;
  let fixture: ComponentFixture<InfoBahnTextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoBahnTextComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoBahnTextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
