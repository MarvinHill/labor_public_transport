import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransportEntryComponent } from './transport-entry.component';

describe('TransportEntryComponent', () => {
  let component: TransportEntryComponent;
  let fixture: ComponentFixture<TransportEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransportEntryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransportEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
