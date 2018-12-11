import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Profile } from '../profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profId: string;
  profile: Profile;
  constructor(private route: ActivatedRoute, private profileService: ProfileService) { }

  ngOnInit() {
    this.route.paramMap
      .subscribe((params: ParamMap) => {
        const id = params.get('id');
        this.profId = id;
    });

    this.profileService.getProfileById(this.profId)
      .subscribe(data => {
        this.profile = data;
        console.log(this.profile);
      });
  }

}
