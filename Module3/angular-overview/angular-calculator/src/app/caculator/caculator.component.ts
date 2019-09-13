import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {

  constructor() { }
number1(n1){
    this.number1 = n1;
}
  number2(n2){
    this.number2 = n2;
  }
  ngOnInit() {
  }

}
