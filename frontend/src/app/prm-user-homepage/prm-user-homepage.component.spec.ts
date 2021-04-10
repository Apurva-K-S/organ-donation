import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrmUserHomepageComponent } from './prm-user-homepage.component';

describe('PrmUserHomepageComponent', () => {
  let component: PrmUserHomepageComponent;
  let fixture: ComponentFixture<PrmUserHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrmUserHomepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrmUserHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
