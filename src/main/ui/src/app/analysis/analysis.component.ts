import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AnalyzedWordsDataSource} from '../service/analyzed-words-data-source.service';
import {WordService} from '../service/word.service';
import {MatPaginator, MatSort} from '@angular/material';
import {fromEvent} from 'rxjs/internal/observable/fromEvent';
import {debounceTime, distinctUntilChanged, tap} from 'rxjs/operators';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit, AfterViewInit {

  dataSource: AnalyzedWordsDataSource;
  constructor(private router: Router, private wordService: WordService) { }

  displayedColumns = ['word', 'inputChars', 'avgDuration', 'minDuration', 'maxDuration', 'wrongCount', 'extraCount', 'backspaceCount', 'enterCount'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild('filterLetter') filterLetterRef: ElementRef;

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

  onRowClick(row) {
    console.log(row);
    this.router.navigateByUrl('');
  }
}
