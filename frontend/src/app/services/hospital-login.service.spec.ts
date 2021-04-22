import { TestBed } from '@angular/core/testing';

import { HospitalLoginService } from './hospital-login.service';

describe('HospitalLoginService', () => {
  let service: HospitalLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HospitalLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
