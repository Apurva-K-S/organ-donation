import { TestBed } from '@angular/core/testing';

import { OrganResponseService } from './organ-response.service';

describe('OrganResponseService', () => {
  let service: OrganResponseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganResponseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
