import { LoginNRegistrationModule } from './login-nregistration.module';

describe('LoginNRegistrationModule', () => {
  let loginNRegistrationModule: LoginNRegistrationModule;

  beforeEach(() => {
    loginNRegistrationModule = new LoginNRegistrationModule();
  });

  it('should create an instance', () => {
    expect(loginNRegistrationModule).toBeTruthy();
  });
});
