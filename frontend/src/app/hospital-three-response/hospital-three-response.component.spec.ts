import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalThreeResponseComponent } from './hospital-three-response.component';

describe('HospitalThreeResponseComponent', () => {
  let component: HospitalThreeResponseComponent;
  let fixture: ComponentFixture<HospitalThreeResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalThreeResponseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalThreeResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
