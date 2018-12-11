export class Profile {
    challengeId: string;
    challengeTitle: string;
    userId: string;
    questScore: number;

    constructor(cId, cTitle, uId, score) {
        this.challengeId = cId;
        this.challengeTitle = cTitle;
        this.userId = uId;
        this.questScore = score;
    }
}
