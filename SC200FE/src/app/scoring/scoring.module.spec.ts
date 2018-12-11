import { ScoringModule } from './scoring.module';

describe('ScoringModule', () => {
  let scoringModule: ScoringModule;

  beforeEach(() => {
    scoringModule = new ScoringModule();
  });

  it('should create an instance', () => {
    expect(scoringModule).toBeTruthy();
  });
});
