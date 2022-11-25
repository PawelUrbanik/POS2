import { TestBed } from '@angular/core/testing';

import { DiscriminantService } from './discriminant.service';

describe('DiscriminantService', () => {
  let service: DiscriminantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DiscriminantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
