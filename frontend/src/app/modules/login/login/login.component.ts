import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { takeUntil } from 'rxjs';
import { AuthenticationUser } from 'src/app/core/models/authentication-user.model';
import { AuthenticationService } from 'src/app/core/services/authentication/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  token = ""
  userToLogin: AuthenticationUser = new AuthenticationUser();

  formLogin = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
  })
  messageError = false;

  constructor(private fb: FormBuilder,
    private authService: AuthenticationService,
    private router: Router) {}

  ngOnInit(): void {
      this.generateToken(36);
  }

  generateToken(length: number): string {
    this.token = '';
    for (let i = 0; i < length; i++) {
      let randomIndex = Math.floor(Math.random() * this.chars.length);
      this.token += this.chars.charAt(randomIndex);
    }
    sessionStorage.setItem('token', this.token);
    return this.token;
  }

  onSubmit() {
  if (this.formLogin.valid) {
    this.authService.getAllUsers().subscribe((userList) => {
      userList.forEach((user) => {
        if (user.email == this.formLogin.get('email')?.value &&
        user.password == this.formLogin.get('password')?.value) {
          this.router.navigate(['/home']);
        } else {
          this.messageError = true;
        }
      })
    });
    }
  }
}
