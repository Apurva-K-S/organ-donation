import { TestBed } from '@angular/core/testing';

import { PriUserOrganListService } from './pri-user-organ-list.service';

describe('PriUserOrganListService', () => {
  let service: PriUserOrganListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PriUserOrganListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
