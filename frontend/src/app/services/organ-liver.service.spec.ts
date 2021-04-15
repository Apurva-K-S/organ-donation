import { TestBed } from '@angular/core/testing';

import { OrganLiverService } from './organ-liver.service';

describe('OrganLiverService', () => {
  let service: OrganLiverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganLiverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
