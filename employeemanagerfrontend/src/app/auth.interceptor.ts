import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from './auth.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const credentials = inject(AuthService).getCredentials();
  if (credentials) {
    const token = btoa(`${credentials.username}:${credentials.password}`);
    return next(req.clone({ setHeaders: { Authorization: `Basic ${token}` } }));
  }
  return next(req);
};
