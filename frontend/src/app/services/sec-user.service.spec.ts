import { TestBed } from '@angular/core/testing';

import { SecUserService } from './sec-user.service';

describe('SecUserService', () => {
  let service: SecUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
