import { Challenge } from './challenge';

export class Profile {
    email: string;
    firstName: string;
    lastName: string;
    userName: string;
    contactNumber: string;
    score: number;
    ranking: number;
    challengeAttempted: Challenge[];
    challengeCreated: Challenge[];
    challengeUpvoted: Challenge[];
    challengeDownvoted: Challenge[];
}
