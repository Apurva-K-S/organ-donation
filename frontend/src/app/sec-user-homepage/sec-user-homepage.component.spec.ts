import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecUserHomepageComponent } from './sec-user-homepage.component';

describe('SecUserHomepageComponent', () => {
  let component: SecUserHomepageComponent;
  let fixture: ComponentFixture<SecUserHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecUserHomepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SecUserHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
