import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalsListComponent } from './hospitals-list.component';

describe('HospitalsListComponent', () => {
  let component: HospitalsListComponent;
  let fixture: ComponentFixture<HospitalsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HospitalsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
