import {Component, Input, OnInit} from '@angular/core';
import {Headline, HEADLINES} from '../../domain/HeadLine';
import {IMAGE_BASE_URL} from '../../common/Constants';

@Component({
  selector: 'app-headline',
  templateUrl: './headline.component.html',
  styleUrls: ['./headline.component.scss']
})
export class HeadLineComponent implements OnInit {

  @Input() headLine: Headline;

  headLineImageUrl: string;

  constructor() {
  }

  ngOnInit() {
    this.headLineImageUrl = IMAGE_BASE_URL + this.headLine.imageName;
  }

}
