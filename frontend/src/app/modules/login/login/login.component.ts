import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeModel } from 'src/app/core/models/employee.model';
import { EmployeeService } from 'src/app/core/services/employee/employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
  token = '';
  userToLogin: EmployeeModel | null = new EmployeeModel();

  formLogin = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(1)]],
    password: ['', [Validators.required, Validators.minLength(8)]],
  });
  messageError = false;

  constructor(
    private fb: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  CheckifFormIsInvalidOrIncomplete(field: string): boolean {
    if (
      this.formLogin.get(field)?.valid &&
      this.formLogin.get(field)?.dirty &&
      this.formLogin.get(field)?.touched
    ) {
      return false;
    } else {
      return true;
    }
  }

  onSubmit() {
    for (const field in this.formLogin.controls) {
      if (this.CheckifFormIsInvalidOrIncomplete(field)) {
        document.getElementById(field)?.classList.add('is-invalid');
      }
    }
    if (this.formLogin.valid) {
      const username = this.formLogin.get('username')?.value as string;
      const password = this.formLogin.get('password')?.value as string;
      if (this.login(username, password)) {
        this.router.navigate(['/home']);
      } else {
        this.messageError = true;
      }
    }
  }

  loginAdmin() {
    this.employeeService.getEmployeeById('0').subscribe((e) => {
      this.userToLogin = e;
      this.userToLogin.picture = this.employeeService.getEmployeePicture('aa');
      sessionStorage.setItem('user', JSON.stringify(this.userToLogin));
      this.router.navigate(['/home'])
    });
  }

  login(username: string, password: string): boolean {
    const employee = this.findEmployeeByUsername(username);
    if (employee && employee.authentication?.authenticate(username, password)) {
      this.userToLogin = employee;
      sessionStorage.setItem('user', JSON.stringify(this.userToLogin));
      return true;
    } else {
      return false;
    }
  }

  logout(): void {
    this.userToLogin = null;
  }

  isAuthenticated(): boolean {
    return this.userToLogin !== null;
  }

  getuserToLogin(): EmployeeModel | null {
    return this.userToLogin;
  }

  private findEmployeeByUsername(username: string): EmployeeModel | undefined {
    this.employeeService.getAllEmployees().subscribe((employeesList) => {
      return employeesList.find((employee) => {
        employee.authentication?.getUsername() == username;
      });
    });
    return undefined;
  }
}
