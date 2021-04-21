import { TestBed } from '@angular/core/testing';

import { HospitalListService } from './hospital-list.service';

describe('HospitalListService', () => {
  let service: HospitalListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HospitalListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
