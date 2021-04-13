import { TestBed } from '@angular/core/testing';

import { ThankyouServiceService } from './thankyou-service.service';

describe('ThankyouServiceService', () => {
  let service: ThankyouServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ThankyouServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
