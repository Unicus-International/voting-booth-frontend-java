package Model;

public class RegisterModel {
}


/*
POST /user/register

request parameters:
  name: string
  email_address: string
  password_one: string
  password_two: string

reply status:
  201: Registration successful
  400: Invalid request
  403: User already exists

reply body:
  none except:
    400: application/json: { "error": <reason> }


 */