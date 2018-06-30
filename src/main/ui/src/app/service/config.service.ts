import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../appsetings';
import {Observable} from 'rxjs/internal/Observable';
import {ConfigEntity} from '../shared/entity/config.entity';
import {BehaviorSubject} from 'rxjs/internal/BehaviorSubject';
import {first, publishLast, refCount, tap} from 'rxjs/operators';

export const UNKNOWN_CONFIG: ConfigEntity = {
  paramId: 1,
  isMarch: false,
  isRepeat: true,
  tipsOnExtra: false,
  tipsOnHard: false,
  hardTime: 800,
  autoRefresh: false
}

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  apiRoot = AppSettings.API_ENDPOINT + "config";
  constructor(private httpClient: HttpClient) { }

  private subject: BehaviorSubject<ConfigEntity> = new BehaviorSubject(UNKNOWN_CONFIG);
  config$: Observable<ConfigEntity> = this.subject.asObservable();

  getConfig(): Observable<ConfigEntity> {
    return this.httpClient.get<ConfigEntity>(`${this.apiRoot}/get`).pipe(
      tap(config => this.subject.next(config)),
      first(),
      publishLast(),
      refCount()
    );
  }

  updateConfig(configEntity: ConfigEntity):Observable<ConfigEntity> {
    return this.httpClient.put<ConfigEntity>(`${this.apiRoot}/put`, configEntity).pipe(
        tap(config => this.subject.next(config)),
        publishLast(),
        refCount());
  }
}
