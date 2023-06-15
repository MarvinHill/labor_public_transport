import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicTransportViewComponent } from './public-transport-view.component';

describe('PublicTransportViewComponent', () => {
  let component: PublicTransportViewComponent;
  let fixture: ComponentFixture<PublicTransportViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublicTransportViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicTransportViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
