import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttemptingChallengeComponent } from './attempting-challenge.component';

describe('AttemptingChallengeComponent', () => {
  let component: AttemptingChallengeComponent;
  let fixture: ComponentFixture<AttemptingChallengeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttemptingChallengeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttemptingChallengeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
