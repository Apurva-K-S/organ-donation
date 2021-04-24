import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalOneRequestformComponent } from './hospital-one-requestform.component';

describe('HospitalOneRequestformComponent', () => {
  let component: HospitalOneRequestformComponent;
  let fixture: ComponentFixture<HospitalOneRequestformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalOneRequestformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalOneRequestformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
