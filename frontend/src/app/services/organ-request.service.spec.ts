import { TestBed } from '@angular/core/testing';

import { OrganRequestService } from './organ-request.service';

describe('OrganRequestService', () => {
  let service: OrganRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
