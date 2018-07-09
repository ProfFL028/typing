import { Injectable } from '@angular/core';
import {AppSettings} from '../appsetings';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';
import {map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WordDetailService {
  apiRoot = AppSettings.API_ENDPOINT + 'word_detail';

  constructor(private httpClient: HttpClient) { }

  getWordDetail(word:string, pageSize: number, pageIndex: number): Observable<WordDetailEntity[]> {
    return this.httpClient.get(this.apiRoot + '/page', {
      params: new HttpParams().set('word', word).set('size', pageSize.toString()).set('page', pageIndex.toString())
    }).pipe(
      map(res => res)
    );
  }
}
