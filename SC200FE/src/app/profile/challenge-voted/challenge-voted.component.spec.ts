import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeVotedComponent } from './challenge-voted.component';

describe('ChallengeVotedComponent', () => {
  let component: ChallengeVotedComponent;
  let fixture: ComponentFixture<ChallengeVotedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeVotedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeVotedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
