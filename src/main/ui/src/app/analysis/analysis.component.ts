import { Component, OnInit } from '@angular/core';
import {AnalyzedWordsDataSource} from '../service/analyzed-words-data-source.service';
import {WordService} from '../service/word.service';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit {

  dataSource: AnalyzedWordsDataSource;
  constructor(private wordService: WordService) { }

  displayedColumns = ['word', 'avgDuration'];

  ngOnInit() {
    this.dataSource = new AnalyzedWordsDataSource(this.wordService);
    this.dataSource.loadAnalyzedWords(30, 1, '');
  }

}
