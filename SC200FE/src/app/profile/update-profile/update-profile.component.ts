// import { ProfileService } from '../profile.service';
// import { Profile } from '../profile';
// import { Component, OnInit, Input } from '@angular/core';
// import { FormBuilder, FormGroup, Validators } from '@angular/forms';

// @Component({
//   selector: 'app-update-profile',
//   templateUrl: './update-profile.component.html',
//   styleUrls: ['./update-profile.component.css']
// })
// export class UpdateProfileComponent implements OnInit {

//   constructor(private fb: FormBuilder, private profileService: ProfileService) { }

//   updateForm: FormGroup;

//   @Input()
//   profile: Profile;

//   ngOnInit() {
//     this.updateForm = this.fb.group({
//       email : [this.profile.email, [Validators.required, Validators.email]],
//       firstName : [this.profile.firstName, [Validators.required]],
//       lastName : [this.profile.lastName, Validators.required],
//       userName : [this.profile.username, Validators.required],
//       contactNumber : [this.profile.phone, [Validators.required, Validators.pattern('^[0-9]{10}$')]]
//     });
//   }

//   get email() { return this.updateForm.get('email'); }

//   get firstName() { return this.updateForm.get('firstName'); }

//   get lastName() { return this.updateForm.get('lastName'); }

//   get userName() { return this.updateForm.get('userName'); }

//   get contactNumber() { return this.updateForm.get('contactNumber'); }

//   onSubmit() {
//     if (this.updateForm.invalid) {
//       console.log('PUT Failed');
//       return;
//     }
//     console.log(this.updateForm.value);
//     this.profile.firstName = this.updateForm.value.firstName;
//     this.profile.lastName = this.updateForm.value.lastName;
//     this.profile.username = this.updateForm.value.userName;
//     this.profile.phone = this.updateForm.value.contactNumber;
//     console.log(this.profile);
//     this.profileService.updateProfile(this.profile.email, this.profile)
//       .subscribe(data => {
//         // console.log(data);
//         console.log('PUT Successful');
//       });
//     alert('The form was updated');
//   }

// }
import { ProfileService } from '../profile.service';
import { Profile } from '../profile';
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
 selector: 'app-update-profile',
 templateUrl: './update-profile.component.html',
 styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

 constructor(private fb: FormBuilder, private profileService: ProfileService) { }

 updateForm: FormGroup;

 @Input()
 profile: Profile;

 ngOnInit() {
   this.updateForm = this.fb.group({
     email : [this.profile.email, [Validators.required, Validators.email]],
     firstName : [this.profile.firstName, [Validators.required]],
     lastName : [this.profile.lastName, Validators.required],

     contactNumber : [this.profile.phone, [Validators.required, Validators.pattern('^[0-9]{10}$')]]
   });
 }

 get email() { return this.updateForm.get('email'); }

 get firstName() { return this.updateForm.get('firstName'); }

 get lastName() { return this.updateForm.get('lastName'); }

 get userName() { return this.updateForm.get('userName'); }

 get contactNumber() { return this.updateForm.get('contactNumber'); }

 onSubmit() {
   if (this.updateForm.invalid) {
     console.log('PUT Failed');
     return;
   }
   console.log(this.updateForm.value);
   this.profile.firstName = this.updateForm.value.firstName;
   this.profile.lastName = this.updateForm.value.lastName;

   this.profile.phone = this.updateForm.value.contactNumber;
   console.log(this.profile);
   this.profileService.updateProfile(this.profile.email, this.profile)
     .subscribe(data => {
       // console.log(data);
       console.log('PUT Successful');
     });
   alert('The form was updated');
 }
}