import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginNRegistrationComponent } from './login-nregistration.component';

describe('LoginNRegistrationComponent', () => {
  let component: LoginNRegistrationComponent;
  let fixture: ComponentFixture<LoginNRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginNRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginNRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
