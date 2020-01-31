import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
// template: '<h1>Hello {{name}}, {{message}}</h1>',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';
  name = 'Achille Van houtte';
  message = 'Bienvenu chez toi';
}
