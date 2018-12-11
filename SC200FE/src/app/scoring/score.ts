export class Score {
    challengeId: string;
    challengeTitle: string;
    userId: string;
    challengeScore: number;
    maxScore: number;
    status: string;

    constructor(cId, cTitle, uId, challengeScore, maxScore, solved) {
        this.challengeId = cId;
        this.challengeTitle = cTitle;
        this.userId = uId;
        this.challengeScore = challengeScore
        this.maxScore = maxScore;
        this.status = solved;
    }
}
