import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-loading-full-screen',
  templateUrl: './loading-full-screen.component.html',
  styleUrls: ['./loading-full-screen.component.scss']
})
export class LoadingFullScreenComponent {
  @Input() loading = false;

}
