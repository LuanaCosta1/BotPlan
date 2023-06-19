import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeModel } from 'src/app/core/models/employee.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit{
  userName = 'Perfil';
  userPicture = '../../../assets/images/icon-person-circle.svg';
  loadingLogout = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.getUserData();
  }

  getUserData() {
    const user: EmployeeModel = JSON.parse(sessionStorage.getItem('user') as string);
    if (user && user !== undefined && user !== null) {
      this.userName = user.name;
      this.userPicture = (user.picture !== undefined) ? user.picture : '../../../assets/images/icon-person-circle.svg';
    } else {
      // retirar depois de concluir parte de login', essa funçao desloga o usuario caso seus dados nao sejam encontrados
      // setTimeout(() => this.logout(), 3000);
    }
  }

  logout() {
    localStorage.clear();
    sessionStorage.clear();
    console.log('router');
    this.loadingLogout = true;
    // setTimeout(() => this.router.navigate(['/login']), 3000)
  }
}
