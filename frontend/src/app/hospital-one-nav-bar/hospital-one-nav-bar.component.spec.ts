import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalOneNavBarComponent } from './hospital-one-nav-bar.component';

describe('HospitalOneNavBarComponent', () => {
  let component: HospitalOneNavBarComponent;
  let fixture: ComponentFixture<HospitalOneNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalOneNavBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalOneNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
