import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "../../navbar/navbar.component";
import { BottombarComponent } from "../../bottombar/bottombar.component";

@Component({
  selector: 'app-index',
  imports: [RouterOutlet, NavbarComponent, BottombarComponent],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {

}
