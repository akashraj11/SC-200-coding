import { ScoringRoutingModule } from './scoring-routing.module';

describe('ScoringRoutingModule', () => {
  let scoringRoutingModule: ScoringRoutingModule;

  beforeEach(() => {
    scoringRoutingModule = new ScoringRoutingModule();
  });

  it('should create an instance', () => {
    expect(scoringRoutingModule).toBeTruthy();
  });
});
