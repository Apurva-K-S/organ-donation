import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganHeartComponent } from './organ-heart.component';

describe('OrganHeartComponent', () => {
  let component: OrganHeartComponent;
  let fixture: ComponentFixture<OrganHeartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganHeartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganHeartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
