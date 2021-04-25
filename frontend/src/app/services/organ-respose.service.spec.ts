import { TestBed } from '@angular/core/testing';

import { OrganResposeService } from './organ-respose.service';

describe('OrganResposeService', () => {
  let service: OrganResposeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganResposeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
