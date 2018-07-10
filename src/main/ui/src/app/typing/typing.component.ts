import {ChangeDetectionStrategy, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {WordService} from '../service/word.service';
import {Observable} from 'rxjs/internal/Observable';
import {ConfigService} from '../service/config.service';
import {first, map, publishLast, refCount, switchMap, tap} from 'rxjs/operators';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: 'app-typing',
  templateUrl: './typing.component.html',
  styleUrls: ['./typing.component.css']
})
export class TypingComponent implements OnInit {

  WORD_COUNT_PER_LINE = 35;
  LINE_COUNT = 6;
  PAGE_COUNT = 4;
  get WORD_SIZE(): number {
    return this.WORD_COUNT_PER_LINE * this.LINE_COUNT * this.PAGE_COUNT;
  }

  @ViewChild('typingContent') typingContent;

  words$: Observable<WordDetailEntity[]>;

  constructor(private r: Router, private router: ActivatedRoute, private wordService: WordService, private configService: ConfigService) {
  }

  ngOnInit() {
    this.router.queryParams.subscribe(params => {
      this.configService.getConfig().subscribe();
      this.refreshWords();
    });
  }

  refreshWords() {
    this.words$ = this.configService.config$.pipe(
      switchMap(config => {
        const wrong_word = this.router.snapshot.queryParams['wrong'];
        return this.wordService.getWords(this.WORD_SIZE, config.isRepeat, wrong_word);
      }),
      first(),
      publishLast(),
      refCount()
    )
  }


  onConfigChange($event) {
    this.configService.updateConfig($event).subscribe(
      () => console.log("success"),
      console.error
    );
    this.typingContent.focusMe();
  }

  onRefreshClick($event) {
    this.typingContent.saveTypingInfo();
    this.refreshWords();
    this.typingContent.refresh();
    this.typingContent.focusMe();
  }
}
