import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  imports: [],
  templateUrl: './counter.html',
  styleUrl: './counter.css'
})
export class Counter {
  i : number = 0

  increment(): void{
    this.i++;
  }

  decrement(): void{
    this.i--;
  }
}
