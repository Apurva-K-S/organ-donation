import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalThreeNavBarComponent } from './hospital-three-nav-bar.component';

describe('HospitalThreeNavBarComponent', () => {
  let component: HospitalThreeNavBarComponent;
  let fixture: ComponentFixture<HospitalThreeNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalThreeNavBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalThreeNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
