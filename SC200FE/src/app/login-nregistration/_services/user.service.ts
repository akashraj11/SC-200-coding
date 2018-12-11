﻿import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../../environments/environment';
import { User } from '../_models';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    

    register(user: User) {
        return this.http.post(environment.apiUrl+`register/api/v1/user/add`, user);
    }

    // update(user: User) {
    //     return this.http.put(`${environment.apiUrl}/users/` + user.id, user);
    // }

}