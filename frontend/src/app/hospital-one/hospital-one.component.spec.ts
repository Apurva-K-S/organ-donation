import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalOneComponent } from './hospital-one.component';

describe('HospitalOneComponent', () => {
  let component: HospitalOneComponent;
  let fixture: ComponentFixture<HospitalOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalOneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
