import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-employees',
  imports: [CommonModule, FormsModule],
  templateUrl: './employees.html',
  styleUrl: './employees.css'
})
export class EmployeesComponent implements OnInit {
  employees: Employee[] = [];
  showModal = false;
  editMode = false;
  errorMessage = '';
  formData: Employee = this.emptyForm();

  constructor(
    private employeeService: EmployeeService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loadEmployees();
  }

  loadEmployees(): void {
    this.employeeService.getAll().subscribe({
      next: (data) => this.employees = data,
      error: () => this.errorMessage = 'Failed to load employees.'
    });
  }

  openAddModal(): void {
    this.editMode = false;
    this.formData = this.emptyForm();
    this.showModal = true;
  }

  openEditModal(employee: Employee): void {
    this.editMode = true;
    this.formData = { ...employee };
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.errorMessage = '';
  }

  saveEmployee(): void {
    if (this.editMode) {
      this.employeeService.update(this.formData).subscribe({
        next: () => { this.loadEmployees(); this.closeModal(); },
        error: (err) => this.errorMessage = err?.error?.message || 'Failed to update employee.'
      });
    } else {
      this.employeeService.add(this.formData).subscribe({
        next: () => { this.loadEmployees(); this.closeModal(); },
        error: (err) => this.errorMessage = err?.error?.message || 'Failed to add employee.'
      });
    }
  }

  deleteEmployee(id: number): void {
    if (!confirm('Are you sure you want to delete this employee?')) return;
    this.employeeService.delete(id).subscribe({
      next: () => this.loadEmployees(),
      error: () => this.errorMessage = 'Failed to delete employee.'
    });
  }

  logout(): void {
    this.authService.logout();
  }

  private emptyForm(): Employee {
    return { name: '', email: '', jobTitle: '', phoneNr: '', imageUrl: '' };
  }
}
