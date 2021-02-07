import { TestBed } from '@angular/core/testing';

import { CcAuthGuardService } from './cc-auth-guard.service';

describe('CcAuthGuardService', () => {
  let service: CcAuthGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CcAuthGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
