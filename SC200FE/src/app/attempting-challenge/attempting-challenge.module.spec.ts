import { AttemptingChallengeModule } from './attempting-challenge.module';

describe('AttemptingChallengeModule', () => {
  let attemptingChallengeModule: AttemptingChallengeModule;

  beforeEach(() => {
    attemptingChallengeModule = new AttemptingChallengeModule();
  });

  it('should create an instance', () => {
    expect(attemptingChallengeModule).toBeTruthy();
  });
});
