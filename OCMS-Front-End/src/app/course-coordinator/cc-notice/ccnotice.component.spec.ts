import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CcnoticeComponent } from './ccnotice.component';

describe('CcnoticeComponent', () => {
  let component: CcnoticeComponent;
  let fixture: ComponentFixture<CcnoticeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CcnoticeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CcnoticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
