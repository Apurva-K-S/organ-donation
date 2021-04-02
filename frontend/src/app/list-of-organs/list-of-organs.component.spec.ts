import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfOrgansComponent } from './list-of-organs.component';

describe('ListOfOrgansComponent', () => {
  let component: ListOfOrgansComponent;
  let fixture: ComponentFixture<ListOfOrgansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOfOrgansComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfOrgansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
