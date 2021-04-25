import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalTwoResponseComponent } from './hospital-two-response.component';

describe('HospitalTwoResponseComponent', () => {
  let component: HospitalTwoResponseComponent;
  let fixture: ComponentFixture<HospitalTwoResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalTwoResponseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalTwoResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
