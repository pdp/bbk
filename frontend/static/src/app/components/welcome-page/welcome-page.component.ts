import { Component, OnInit } from '@angular/core';
import {Headline, HEADLINES} from '../../domain/HeadLine';

@Component({
  selector: 'app-welcome-page',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.scss']
})
export class WelcomePageComponent implements OnInit {

  headLines: Headline [] = HEADLINES;

  constructor() { }

  ngOnInit() {
  }

}
