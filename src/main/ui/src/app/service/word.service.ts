import { Injectable } from '@angular/core';

import { AppSettings } from '../appsetings';
import { map } from 'rxjs/operators';
import {HttpClient, HttpParams} from '@angular/common/http';
import {WordEntity} from '../shared/entity/word.entity';
import * as _ from 'lodash';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';

@Injectable({
  providedIn: 'root'
})
export class WordService {
  apiRoot = AppSettings.API_ENDPOINT + "word/";
  constructor(private httpClient: HttpClient) { }

  getWords(wordCount: number, isRepeat = false) {
    const params = new HttpParams().set('wordCount', wordCount + '').set('isrepeat', isRepeat + '');

    return this.httpClient
      .get<WordEntity[]>(`${this.apiRoot}get_words?${params.toString()}`, {})
      .pipe(map(data => {
        const wordDetails: WordDetailEntity[] = new Array();
        data.map( d => {
          let wordDetail: WordDetailEntity = new WordDetailEntity();
          wordDetail.word = d;
          wordDetails.push(wordDetail);
        });
        return wordDetails;
      }));
  }
}
