import {DataSource} from '@angular/cdk/table';
import {AnalyzedWordEntity} from '../shared/entity/analyzed-word.entity';
import {Injectable} from '@angular/core';
import {CollectionViewer} from '@angular/cdk/collections';
import {Observable} from 'rxjs/internal/Observable';
import {BehaviorSubject} from 'rxjs/internal/BehaviorSubject';
import {WordService} from './word.service';
import {catchError, finalize} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AnalyzedWordsDataSource implements DataSource<AnalyzedWordEntity> {
  private analyzedWordSubject = new BehaviorSubject<AnalyzedWordEntity[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);

  public loading$: Observable<boolean> = this.loadingSubject.asObservable();

  constructor(private wordService: WordService) {

  }

  loadAnalyzedWords(pageSize: number, pageIndex: number, filterLetter: string) {
    this.loadingSubject.next(true);
    this.wordService.getAnalyzedWords(pageSize, pageIndex, filterLetter).pipe(
      catchError(()=>[]),
      finalize(() => this.loadingSubject.next(false))
    ).subscribe(analyzedWords => this.analyzedWordSubject.next(analyzedWords));
  }

  connect(collectionViewer: CollectionViewer): Observable<AnalyzedWordEntity[]> {
    return this.analyzedWordSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.analyzedWordSubject.complete();
    this.loadingSubject.complete();
  }

}