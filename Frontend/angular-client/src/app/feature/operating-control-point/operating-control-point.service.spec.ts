import { TestBed } from '@angular/core/testing';

import { OperatingControlPointService } from './operating-control-point.service';

describe('OperatingControlPointService', () => {
  let service: OperatingControlPointService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OperatingControlPointService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
