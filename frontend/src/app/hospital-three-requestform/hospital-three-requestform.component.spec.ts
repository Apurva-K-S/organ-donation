import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalThreeRequestformComponent } from './hospital-three-requestform.component';

describe('HospitalThreeRequestformComponent', () => {
  let component: HospitalThreeRequestformComponent;
  let fixture: ComponentFixture<HospitalThreeRequestformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalThreeRequestformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalThreeRequestformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
