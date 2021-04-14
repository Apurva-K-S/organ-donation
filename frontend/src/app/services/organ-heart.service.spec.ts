import { TestBed } from '@angular/core/testing';

import { OrganHeartService } from './organ-heart.service';

describe('OrganHeartService', () => {
  let service: OrganHeartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganHeartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
