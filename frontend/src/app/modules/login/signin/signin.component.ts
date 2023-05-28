import { Component } from '@angular/core';
import {
  Validators,
  FormBuilder,
} from '@angular/forms';
import { AuthenticationUser } from 'src/app/core/models/authentication-user.model';
import { AuthenticationService } from 'src/app/core/services/authentication/authentication.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss'],
})
export class SigninComponent {
  token = '';
  chars = '';
  id = 0;
  userToRegister: AuthenticationUser = new AuthenticationUser();

  formRegister = this.fb.group({
    firstName: ['', [Validators.required, Validators.minLength(2)]],
    lastName: ['', [Validators.required, Validators.minLength(2)]],
    email: ['', [Validators.required, Validators.email]],
    password: [
      '',
      [
        Validators.required,
        Validators.pattern('^(?=.*[A-Za-z])(?=.*d)[A-Za-zd]{8,}$'),
      ],
    ],
    repeatPassword: [
      '',
      [
        Validators.required,
        Validators.pattern('^(?=.*[A-Za-z])(?=.*d)[A-Za-zd]{8,}$'),
      ],
    ],
  });

  constructor(
    private fb: FormBuilder,
    private authService: AuthenticationService
  ) {}

  generateToken(length: number): string {
    this.token = '';
    for (let i = 0; i < length; i++) {
      let randomIndex = Math.floor(Math.random() * this.chars.length);
      this.token += this.chars.charAt(randomIndex);
    }
    sessionStorage.setItem('token', this.token);
    return this.token;
  }

  getLastUserId(): number[] {
    let idUser = 0;
    let idEmployee = 0;
    this.authService.getAllUsers().subscribe((userList) => {
      userList.forEach((user) => {
        idUser = user.id;
        idEmployee = user.idEmployee;
      });
      return [idUser++, idEmployee++];
    });
    return [idUser++, idEmployee++];
  }

  onSubmit() {
    const username = this.formRegister.get('email')?.value?.split('@')[0];
    if (this.formRegister.valid &&
      this.formRegister.get('password')?.value == this.formRegister.get('repeatPassword')?.value) {
      this.userToRegister = {
        id: this.getLastUserId()[0] + 1,
        idEmployee: this.getLastUserId()[1] + 1,
        fullName:
          this.formRegister.get('firstName')?.value +
          ' ' +
          this.formRegister.get('lastName')?.value,
        user: username as string,
        email: this.formRegister.get('email')?.value as string,
        password: this.formRegister.get('password')?.value as string,
        token: this.generateToken(32),
      };
      this.authService.addUser(this.userToRegister).subscribe();
    }
  }
}
