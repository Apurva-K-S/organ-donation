import { TestBed } from '@angular/core/testing';

import { OrganKidneyService } from './organ-kidney.service';

describe('OrganKidneyService', () => {
  let service: OrganKidneyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganKidneyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
