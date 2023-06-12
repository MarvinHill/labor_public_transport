import { TestBed } from '@angular/core/testing';

import { ShuttleSearchService } from './shuttle-search.service';

describe('ShuttleSearchService', () => {
  let service: ShuttleSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShuttleSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
