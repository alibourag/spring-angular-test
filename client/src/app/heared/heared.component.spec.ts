import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HearedComponent } from './heared.component';

describe('HearedComponent', () => {
  let component: HearedComponent;
  let fixture: ComponentFixture<HearedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HearedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HearedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
