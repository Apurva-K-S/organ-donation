import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganLiverComponent } from './organ-liver.component';

describe('OrganLiverComponent', () => {
  let component: OrganLiverComponent;
  let fixture: ComponentFixture<OrganLiverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganLiverComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrganLiverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
