import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalTwoComponent } from './hospital-two.component';

describe('HospitalTwoComponent', () => {
  let component: HospitalTwoComponent;
  let fixture: ComponentFixture<HospitalTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalTwoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
