import { Component } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, concatMap, last, map, of } from 'rxjs';
import { AuthenticationUser } from 'src/app/core/models/authentication-user.model';
import { EmployeeModel } from 'src/app/core/models/employee.model';
import { EmployeeService } from 'src/app/core/services/employee/employee.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss'],
})
export class SigninComponent {
  token = '';
  chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRTUVWXYZ1234567890.';
  id = 0;
  userToRegister: EmployeeModel = new EmployeeModel();
  autheticationUser: AuthenticationUser = new AuthenticationUser();
  notificationMessage = '';
  loadingRegister = false;

  formRegister = this.fb.group({
    firstName: ['', [Validators.required, Validators.minLength(2)]],
    lastName: ['', [Validators.required, Validators.minLength(2)]],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required]],
    repeatPassword: ['', [Validators.required]],
  });

  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  CheckifFormIsInvalidOrIncomplete(field: string): boolean {
    if (
      this.formRegister.get(field)?.valid &&
      this.formRegister.get(field)?.dirty &&
      this.formRegister.get(field)?.touched
    ) {
      return false;
    } else {
      return true;
    }
  }

  generateToken(length: number): Observable<void> {
    this.token = '';
    for (let i = 0; i < length; i++) {
      let randomIndex = Math.floor(Math.random() * this.chars.length);
      this.token += this.chars.charAt(randomIndex);
    }
    sessionStorage.setItem('token', this.token);
    localStorage.setItem('token', this.token);
    return of(void 0);
  }

  authenticateNewUser(): Observable<void> {
    const username = this.formRegister
      .get('email')
      ?.value?.split('@')[0] as string;
    const password = this.formRegister.get('password')?.value as string;
    this.autheticationUser.setUsername(username);
    this.autheticationUser.setPassword(password);
    this.autheticationUser.setToken(this.token);
    return of(void 0);
  }

  registerNewUser(): Observable<void> {
    this.loadingRegister = true;
    for (const field in this.formRegister.controls) {
      if (this.CheckifFormIsInvalidOrIncomplete(field)) {
        document.getElementById(field)?.classList.add('is-invalid');
        this.loadingRegister = false;
      }
    }
    return this.generateToken(32).pipe(
      concatMap((token) => {
        if (token !== null) {
          return this.authenticateNewUser();
        } else {
          return of(false);
        }
      }),
      map(() => {
        this.register()
        return void 0;
      })
    );
  }

  generateId(): string {
    const timestamp = Date.now().toString();
    const random = Math.random().toString(36).substring(2, 9);
    return timestamp + random;
  }


  register() {
    if (
      this.formRegister.valid &&
      this.formRegister.get('password')?.value ==
      this.formRegister.get('repeatPassword')?.value
    ) {
      this.userToRegister = {
        id: this.generateId(),
        name:
          this.formRegister.get('firstName')?.value +
          ' ' +
          this.formRegister.get('lastName')?.value,
        authentication: this.autheticationUser,
        isWorking: true,
        admin: false,
      };
      const notificationToast = document.getElementById('liveToast');
      setTimeout(() => {
        this.employeeService.addEmployee(this.userToRegister).subscribe({
          complete: () => {
            sessionStorage.setItem('user', JSON.stringify(this.userToRegister));
            this.notificationMessage =
              'Usuário cadastrado com sucesso, estaremos te redirecionando para a página principal';
            this.loadingRegister = false;
            this.router.navigate(['/home']);
          },
          error: (error) => {
            console.log(error);
            this.loadingRegister = false;
            this.notificationMessage =
              'Não foi possível cadastrar usuário. Por favor, tente novamente mais tarde.';
          },
        });
      }, 3000);
    } else {
      this.loadingRegister = false;
    }
  }

  onSubmit() {
    this.registerNewUser().subscribe();
  }
}
