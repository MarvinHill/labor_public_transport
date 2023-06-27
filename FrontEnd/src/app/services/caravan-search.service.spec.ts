import { TestBed } from '@angular/core/testing';

import { CaravanSearchService } from './caravan-search.service';

describe('CaravanSearchService', () => {
  let service: CaravanSearchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CaravanSearchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
