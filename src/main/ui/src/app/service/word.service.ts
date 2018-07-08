import {Injectable} from '@angular/core';

import {AppSettings} from '../appsetings';
import {map} from 'rxjs/operators';
import {HttpClient, HttpParams} from '@angular/common/http';
import {WordEntity} from '../shared/entity/word.entity';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';
import {Observable} from 'rxjs/internal/Observable';
import {AnalyzedWordEntity} from '../shared/entity/analyzed-word.entity';

@Injectable({
  providedIn: 'root'
})
export class WordService {
  apiRoot = AppSettings.API_ENDPOINT + 'word';

  constructor(private httpClient: HttpClient) {
  }

  getWords(wordCount: number, isRepeat = false) {
    const params = new HttpParams().set('wordCount', wordCount + '').set('isrepeat', isRepeat + '');

    return this.httpClient
      .get<WordEntity[]>(`${this.apiRoot}/get_words?${params.toString()}`, {})
      .pipe(map(data => {
        const wordDetails: WordDetailEntity[] = new Array();
        data.map(d => {
          let wordDetail: WordDetailEntity = new WordDetailEntity();
          wordDetail.word = d;
          wordDetails.push(wordDetail);
        });
        return wordDetails;
      }));
  }

  getAnalyzedWords(pageSize: number, pageIndex: number, filterLetter: string): Observable<AnalyzedWordEntity[]> {
    return this.httpClient.get<AnalyzedWordEntity[]>(`${this.apiRoot}/get_analyzed_words`, {
        params: new HttpParams()
          .set('pageIndex', pageIndex.toString())
          .set('pageSize', pageSize.toString())
          .set('filterLetter', filterLetter)
    }).pipe(
      map(res => res)
    );
  }
}
