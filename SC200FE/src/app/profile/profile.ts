import { Challenge } from './challenge';

export class Profile {
    email: string;
    firstName: string;
    lastName: string;
    username: string;
    phone: number;
    score: number;
    userId:string;
    dateOfBirth:string;
    ranking: number;
    challengeAttempted: Challenge[];
    challengeCreated: Challenge[];
    challengeUpvoted: Challenge[];
    challengeDownvoted: Challenge[];
}
