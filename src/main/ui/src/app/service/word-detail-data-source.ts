import {DataSource} from '@angular/cdk/table';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';
import {CollectionViewer} from '@angular/cdk/collections';
import {Observable} from 'rxjs/internal/Observable';
import {Injectable} from '@angular/core';
import {WordDetailService} from './word-detail.service';
import {BehaviorSubject} from 'rxjs/internal/BehaviorSubject';
import {catchError, finalize, tap} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class WordDetailDataSource implements DataSource<WordDetailEntity> {

  private wordDetailSubject = new BehaviorSubject<WordDetailEntity[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);
  private totalNumberSubject = new BehaviorSubject<number>(0);

  public loading$: Observable<boolean> = this.loadingSubject.asObservable();
  public totalNumber$: Observable<number> = this.totalNumberSubject.asObservable();

  constructor(private wordDetailService: WordDetailService) {

  }

  loadWordDetails(word: string, pageSize: number, pageIndex: number) {
    this.loadingSubject.next(true);
    this.wordDetailService.getWordDetail(word, pageSize, pageIndex).pipe(
      catchError(()=> []),
      finalize(()=> this.loadingSubject.next(false))
    ).subscribe(page=> {
      this.wordDetailSubject.next(page.content);
      this.totalNumberSubject.next(page.totalNumber);
    });
  }

  connect(collectionViewer: CollectionViewer): Observable<WordDetailEntity[]> {
    return this.wordDetailSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.wordDetailSubject.complete();
    this.loadingSubject.complete();
  }

}