import { Component, OnInit } from '@angular/core';
import {Score, SCORES} from '../../domain/Score';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.scss']
})
export class ScoreComponent implements OnInit {

  scores: Score[] = SCORES;

  constructor() { }

  ngOnInit() {
  }

}
