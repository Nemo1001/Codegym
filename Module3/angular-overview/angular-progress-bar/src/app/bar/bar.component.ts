import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-bar',
  templateUrl: './bar.component.html',
  styleUrls: ['./bar.component.css']
})
export class BarComponent implements OnInit {
  @Input() backgroundColor = '#d9d9d9';
  @Input() progressColor = '#4CAF50';
  @Input() width = 50;

  onChange(value) {

    this.width = value;
  }
  constructor() { }

  ngOnInit() {
  }

}
