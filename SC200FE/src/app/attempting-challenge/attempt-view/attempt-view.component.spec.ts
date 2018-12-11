import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttemptViewComponent } from './attempt-view.component';

describe('AttemptViewComponent', () => {
  let component: AttemptViewComponent;
  let fixture: ComponentFixture<AttemptViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttemptViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttemptViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
