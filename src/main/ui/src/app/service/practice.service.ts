import { Injectable } from '@angular/core';
import {PracticeEntity} from '../shared/entity/practice.entity';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';
import {Observable} from 'rxjs/internal/Observable';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../appsetings';

class PracticeWithWordDetail {
  practice: PracticeEntity;
  wordDetails: WordDetailEntity[];
}

@Injectable({
  providedIn: 'root'
})
export class PracticeService {
  apiRoot = AppSettings.API_ENDPOINT + 'practice';
  constructor(private httpClient: HttpClient) { }

  save(practice: PracticeEntity, wordDetails: WordDetailEntity[]): Observable<any> {
    let practiceWithWordDetails:PracticeWithWordDetail = new PracticeWithWordDetail();
    practiceWithWordDetails.practice = practice;
    practiceWithWordDetails.wordDetails = wordDetails;
    return this.httpClient.put<any>(this.apiRoot +'/save', practiceWithWordDetails);
  }
}
