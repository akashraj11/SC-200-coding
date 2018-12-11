export class ScoringModel {
    challengeId: string;
    challengeTitle: string;
    userId: string;
    challengeScore: number;
    solved: number;

    constructor(cId, cTitle, uId, score, solved) {
        this.challengeId = cId;
        this.challengeTitle = cTitle;
        this.userId = uId;
        this.challengeScore = score;
        this.solved = solved;
    }
}
