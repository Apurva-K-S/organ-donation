import { TestBed } from '@angular/core/testing';

import { OrganEyesService } from './organ-eyes.service';

describe('OrganEyesService', () => {
  let service: OrganEyesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganEyesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
