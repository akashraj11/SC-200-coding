import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeAttemptedComponent } from './challenge-attempted.component';

describe('ChallengeAttemptedComponent', () => {
  let component: ChallengeAttemptedComponent;
  let fixture: ComponentFixture<ChallengeAttemptedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeAttemptedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeAttemptedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
