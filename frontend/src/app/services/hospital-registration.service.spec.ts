import { TestBed } from '@angular/core/testing';

import { HospitalRegistrationService } from './hospital-registration.service';

describe('HospitalRegistrationService', () => {
  let service: HospitalRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HospitalRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
