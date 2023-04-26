import { TestBed } from '@angular/core/testing';

import { MapDetailsObserverService } from './map-details-observer.service';

describe('MapDetailsObserverService', () => {
  let service: MapDetailsObserverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MapDetailsObserverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
