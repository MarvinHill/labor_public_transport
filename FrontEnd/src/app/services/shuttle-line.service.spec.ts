import { TestBed } from '@angular/core/testing';

import { ShuttleLineService } from './shuttle-line.service';

describe('ShuttleLineService', () => {
  let service: ShuttleLineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShuttleLineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
