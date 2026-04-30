import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private credentials: { username: string; password: string } | null = null;

  constructor(private router: Router) {
    const stored = sessionStorage.getItem('auth');
    if (stored) {
      try { this.credentials = JSON.parse(stored); } catch { }
    }
  }

  setCredentials(username: string, password: string): void {
    this.credentials = { username, password };
    sessionStorage.setItem('auth', JSON.stringify(this.credentials));
  }

  clearCredentials(): void {
    this.credentials = null;
    sessionStorage.removeItem('auth');
  }

  getCredentials() { return this.credentials; }

  isLoggedIn(): boolean { return this.credentials !== null; }

  logout(): void {
    this.clearCredentials();
    this.router.navigate(['/login']);
  }
}
