import { TestBed } from '@angular/core/testing';

import { FacultyAuthGuardService } from './faculty-auth-guard.service';

describe('FacultyAuthGuardService', () => {
  let service: FacultyAuthGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FacultyAuthGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
