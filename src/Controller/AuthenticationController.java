package Controller;

import View.*;

public class AuthenticationController {
    LoginView loginView;
    LogoutView logoutView;

}

/*
POST /user/login

request parameters:
  email_address: string
  password: string

reply status:
  204: Login successful
  403: Wrong password

reply headers:
  X-Session-Id: <session>

reply body:
  none

 ----------------------------------------

GET /user/logout

request headers:
  X-Session-Id: <session>

reply status:
  204: Logout successful
 */