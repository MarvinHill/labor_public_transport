import { TestBed } from '@angular/core/testing';

import { CampingSearchService } from './camping-search.service';

describe('CampingSearchService', () => {
  let service: CampingSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CampingSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
