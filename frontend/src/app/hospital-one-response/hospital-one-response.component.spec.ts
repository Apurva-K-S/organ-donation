import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalOneResponseComponent } from './hospital-one-response.component';

describe('HospitalOneResponseComponent', () => {
  let component: HospitalOneResponseComponent;
  let fixture: ComponentFixture<HospitalOneResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalOneResponseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalOneResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
