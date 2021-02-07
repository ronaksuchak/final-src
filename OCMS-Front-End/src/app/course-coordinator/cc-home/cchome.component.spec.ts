import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CchomeComponent } from './cchome.component';

describe('CchomeComponent', () => {
  let component: CchomeComponent;
  let fixture: ComponentFixture<CchomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CchomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CchomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
