import { CreateChallengeModule } from './create-challenge.module';

describe('CreateChallengeModule', () => {
  let createChallengeModule: CreateChallengeModule;

  beforeEach(() => {
    createChallengeModule = new CreateChallengeModule();
  });

  it('should create an instance', () => {
    expect(createChallengeModule).toBeTruthy();
  });
});
