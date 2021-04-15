import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganEyesComponent } from './organ-eyes.component';

describe('OrganEyesComponent', () => {
  let component: OrganEyesComponent;
  let fixture: ComponentFixture<OrganEyesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganEyesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganEyesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
