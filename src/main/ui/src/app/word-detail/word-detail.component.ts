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

  displayedColumns = ['inputChars', 'typingDuration', 'inputValue','isExtra', 'backspaceEntered', 'enterEntered'];

  dataSource: WordDetailDataSource;
  @Input()
  word: string;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private route: Router, private wordDetailService: WordDetailService) { }

  ngOnInit() {
    this.dataSource = new WordDetailDataSource(this.wordDetailService);
    this.dataSource.loadWordDetails(this.word, 5, 0);
  }

  ngAfterViewInit(): void {
    this.paginator.page.pipe(tap(()=> this.loadWordDetails())).subscribe()
  }

  loadWordDetails() {
    this.dataSource.loadWordDetails(this.word, this.paginator.pageSize, this.paginator.pageIndex);
  }
}
