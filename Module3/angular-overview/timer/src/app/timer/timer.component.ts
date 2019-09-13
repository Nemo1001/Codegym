import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css']
})
export class TimerComponent implements OnInit, OnDestroy, OnChanges {

  curSeconds: number;

  @Input()
  set seconds(val) {
    if (this.validateSecond(val)) {
      this.curSeconds = val;
    } else {
      this.curSeconds = 10;
    }

  }
  get seconds() {
    return this.curSeconds;
  }

  @Output() finish = new EventEmitter();

  interval: number;
  isPaused: boolean;
  initSeconds: number;

  constructor() { }

  ngOnInit() {
    console.log('Timer start!');
    this.isPaused = true;
    this.initSeconds = this.curSeconds;
  }

  ngOnDestroy() {
    console.log('Timer end!');
  }

  ngOnChanges(v: SimpleChanges) {
    console.log(v);
  }


  private validateSecond(value: any): boolean {
    if (Number.isNaN(Number(value))) {
      return false;
    } else {
      return true;
    }
  }

  public startTimer() {
    this.isPaused = false;
    this.interval = setInterval(() => {
      console.log(new Date().getTime());

      if (this.curSeconds > 0) {
        this.seconds--;
      } else {

        this.finish.emit();
        this.stopTimer();
      }

    }, 1000);
  }

  public stopTimer() {
    this.isPaused = true;
    clearInterval(this.interval);
  }

  public resetTimer() {
    this.stopTimer();
    this.curSeconds = this.initSeconds;
  }
}
