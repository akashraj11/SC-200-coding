import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeCreatedComponent } from './challenge-created.component';

describe('ChallengeCreatedComponent', () => {
  let component: ChallengeCreatedComponent;
  let fixture: ComponentFixture<ChallengeCreatedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChallengeCreatedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeCreatedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
