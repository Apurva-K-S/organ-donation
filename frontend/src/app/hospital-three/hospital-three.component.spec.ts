import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalThreeComponent } from './hospital-three.component';

describe('HospitalThreeComponent', () => {
  let component: HospitalThreeComponent;
  let fixture: ComponentFixture<HospitalThreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalThreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
