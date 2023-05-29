export class AuthenticationUser {
  private username: string;
  private password: string;
  private token: string;

  constructor() {
    this.username = '';
    this.password = '';
    this.token = '';
  }

  setUsername(username: string): void {
    this.username = username;
  }

  setPassword(password: string): void {
    this.password = password;
  }

  setToken(token: string): void {
    this.token = token;
  }

  getUsername(): string {
    return this.username;
  }

  getPassword(): string {
    return '********';
  }

  getToken(): string {
    return this.token;
  }

  authenticate(username: string, password: string): boolean {
    return username === this.username && password === this.password;
  }
}
