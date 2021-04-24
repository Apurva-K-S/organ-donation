import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalTwoRequestformComponent } from './hospital-two-requestform.component';

describe('HospitalTwoRequestformComponent', () => {
  let component: HospitalTwoRequestformComponent;
  let fixture: ComponentFixture<HospitalTwoRequestformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalTwoRequestformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalTwoRequestformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
