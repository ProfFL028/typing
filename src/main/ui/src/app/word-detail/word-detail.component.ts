import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {WordDetailService} from '../service/word-detail.service';
import {WordDetailDataSource} from '../service/word-detail-data-source';
import {MatPaginator} from '@angular/material';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-word-detail',
  templateUrl: './word-detail.component.html',
  styleUrls: ['./word-detail.component.css']
})
export class WordDetailComponent implements OnInit, AfterViewInit {

  displayedColumns = ['typingDuration', 'isWrong', 'isExtra', 'backspaceEntered', 'enterEntered', 'inputValue'];

  wordDetailDataSource: WordDetailDataSource;
  @Input()
  word: string;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private route: Router, private wordDetailService: WordDetailService) { }

  ngOnInit() {
    this.wordDetailDataSource = new WordDetailDataSource(this.wordDetailService);
    this.wordDetailDataSource.loadWordDetails(this.word, 5, 0);
  }

  ngAfterViewInit(): void {
    this.paginator.page.pipe(tap(()=> this.loadWordDetails())).subscribe()
  }

  loadWordDetails() {
    this.wordDetailDataSource.loadWordDetails(this.word, this.paginator.pageSize, this.paginator.pageIndex);
  }
}
