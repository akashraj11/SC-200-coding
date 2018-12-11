export class Voting {
    challengeId: string;
    challengeTitle: string;
    userId: string;

    constructor(cId, cTitle, uId) {
        this.challengeId = cId;
        this.challengeTitle = cTitle;
        this.userId = uId;
    }
}
