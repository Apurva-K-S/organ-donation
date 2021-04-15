import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganKidneyComponent } from './organ-kidney.component';

describe('OrganKidneyComponent', () => {
  let component: OrganKidneyComponent;
  let fixture: ComponentFixture<OrganKidneyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganKidneyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganKidneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
