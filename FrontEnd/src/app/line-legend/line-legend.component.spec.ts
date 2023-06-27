import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LineLegendComponent } from './line-legend.component';

describe('LineLegendComponent', () => {
  let component: LineLegendComponent;
  let fixture: ComponentFixture<LineLegendComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LineLegendComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LineLegendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
