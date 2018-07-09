import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AnalyzedWordsDataSource} from '../service/analyzed-words-data-source.service';
import {WordService} from '../service/word.service';
import {MatPaginator} from '@angular/material';
import {fromEvent} from 'rxjs/internal/observable/fromEvent';
import {debounceTime, distinctUntilChanged, tap} from 'rxjs/operators';
import {Router} from '@angular/router';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css'],
  animations: [
      trigger('detailExpand', [
          state('collapsed', style({ height: '0px', minHeight: '0', visibility: 'hidden' })),
          state('expanded', style({ height: '*', visibility: 'visible' })),
          transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
      ]),
  ],
})
export class AnalysisComponent implements OnInit, AfterViewInit {

  dataSource: AnalyzedWordsDataSource;
  constructor(private router: Router, private wordService: WordService) { }

  displayedColumns = ['word', 'inputChars', 'avgDuration', 'minDuration', 'maxDuration', 'wrongCount', 'extraCount', 'backspaceCount', 'enterCount'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild('filterLetter') filterLetterRef: ElementRef;

  isExpansionDetailRow = (i: number, row: Object) => row.hasOwnProperty('detailRow');
  expandedElement: any;

  ngOnInit() {
    this.dataSource = new AnalyzedWordsDataSource(this.wordService);
    this.dataSource.loadAnalyzedWords(10, 1, '');
  }

  ngAfterViewInit() {
    fromEvent(this.filterLetterRef.nativeElement, 'keyup').pipe(
      debounceTime(150),
      distinctUntilChanged(),
      tap(() =>{
        this.paginator.pageIndex = 0;
        this.loadWordAnalysis();
      })
    ).subscribe();

    this.paginator.page.pipe(tap(() => this.loadWordAnalysis())).subscribe();
  }

  loadWordAnalysis() {
    this.dataSource.loadAnalyzedWords(this.paginator.pageSize, this.paginator.pageIndex, this.filterLetterRef.nativeElement.value);
  }

}
