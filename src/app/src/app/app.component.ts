import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'app';
  hostname = 'Loading...'; // Initialize with a default value
  constructor(private http: HttpClient) { // Inject HttpClient
    this.fetchHostname();
  }
  fetchHostname() {
    this.http.get<any>('http://localhost:3000/api/hostname') // Make the API request
      .subscribe(data => {
        this.hostname = data.hostname; // Update hostname property
        console.log('Hostname:', data);
      });
  }
}
