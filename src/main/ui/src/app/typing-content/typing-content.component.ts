import {ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnInit, ViewChild} from '@angular/core';
import {ConfigEntity} from '../shared/entity/config.entity';
import {WordEntity} from '../shared/entity/word.entity';
import {WordService} from '../service/word.service';
import {PracticeEntity} from '../shared/entity/practice.entity';
import {WordDetailEntity} from '../shared/entity/word-detail.entity';
import {PracticeService} from '../service/practice.service';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-typing-content',
  templateUrl: './typing-content.component.html',
  styleUrls: ['./typing-content.component.css']
})
export class TypingContentComponent implements OnInit {
  @Input()
  config: ConfigEntity;
  @Input()
  wordDetails: WordDetailEntity[];
  @Input()
  wordCountPerLine: number = 35;
  @Input()
  lineCount: number = 6;
  @Input()
  pageCount: number = 10;

  pageIndex = 0;
  curI = 0;
  curJ = 0;

  practice: PracticeEntity;
  printSpeed = 0;

  isStarted = false;
  isFinished = false;

  inputDate: Date = new Date();

  inputValues: string[];

  @ViewChild('myCD') myCounterDown;

  constructor(private cdRef: ChangeDetectorRef, private practiceService: PracticeService) { }

  ngOnInit() {
    this.refresh();
  }

  refreshInputs() {
    this.inputValues = new Array(this.wordPerPage);
    for (let i = 0; i < this.wordPerPage; i++) {
      this.inputValues[i] = '';
    }
  }
  refresh() {
    this.refreshInputs();
    this.pageIndex = 0;
    this.curI = 0;
    this.curJ = 0;

    this.practice = new PracticeEntity();

    if (this.myCounterDown && this.isStarted) {
      this.myCounterDown.restart();
    }
    this.isStarted = false;
    this.isFinished = false;
    this.inputDate = new Date();
  }

  listenKeyDown($event) {
    console.log($event);
    // 记录当前字的按键。并更新有效按键次数
    if ($event.key === 'Process' || ($event.key >= 'a' && $event.key <= 'z')) {
      this.wordDetails[this.currentIndexWithPage].appendChar($event.code);

      if ($event.code === 'Backspace') {
        this.wordDetails[this.currentIndexWithPage].subKeys();
        this.wordDetails[this.currentIndexWithPage].backspaceEntered = true;
      } else if ($event.code >= 'KeyA' && $event.code <= 'KeyZ') {
        this.wordDetails[this.currentIndexWithPage].addKeys();
      }
    }
    // 如果删除键，则回到前一个单元格
    if ($event.key === 'Backspace' && $event.code === 'Backspace') {
      // 如果在第一个位置，不处理;
      // 更新坐标
      if (this.curI === 0 && this.curJ === 0) {
        return ;
      }
      this.curJ--;
      if (this.curJ < 0) {
        this.curJ = this.wordCountPerLine - 1;
        this.curI -= 1;
      }

      // 更新总输入数、正确数、删除键次数
      this.practice.totalCount -= 1;
      if(!this.wordDetails[this.currentIndexWithPage].isWrong) {
        this.practice.rightCount -= 1;
      }
      this.practice.backspaceCount += 1;

      // 重置wordDetails[this.currentIndexWithPage]
      this.wordDetails[this.currentIndexWithPage].reset();

      // 将当前位置input选中
      this.selectInput(this.curI, this.curJ);
      // 更新时间
      this.inputDate = new Date();
    }

    if ($event.code === 'Enter') {
      this.practice.enterCount += 1;
      this.wordDetails[this.currentIndexWithPage].enterEntered = true;
    }

    // 如果输入的是字母，则开始计时等。
    if ($event.code >= 'KeyA' && $event.code <= 'KeyZ') {
      if (!this.isStarted) {
        this.myCounterDown.restart();
        this.myCounterDown.begin();

        this.isStarted = !this.isStarted;
        this.practice.practiceTime = new Date();
        this.inputDate = new Date();
      }
    }
  }

  listenKeyUp($event) {
  }

  onValueChanged(i, j, $event) {
    // 去除空格
    let newValue = $event.target.value.trim();

    if (newValue >= 'a' && newValue <= 'z') {
      $event.target.value = '';
      return ;
    }

    $event.target.value = newValue;
    this.inputValues[i * this.wordCountPerLine + j] = newValue;

    // 更新wordDetails的值
    const inputIndex = i * this.wordCountPerLine + j + this.pageIndex * this.wordPerPage;
    this.wordDetails[inputIndex].updateValue(newValue);
    // 去除非中文
    if (!/^[\u4E00-\u9FA5]+$/.test(newValue)) {
      newValue = $event.target.value = '';
    }

    if (newValue.length >= 1) {
      // 更新totalCount, wordCountPerLine
      this.practice.totalCount += 1;
      if (newValue === this.wordDetails[inputIndex].word.word) {
        this.practice.rightCount += 1;
      }
      // 记录打字时间
      const now = new Date();
      this.wordDetails[inputIndex].typingDuration = now.getTime() - this.inputDate.getTime();
      this.inputDate = now;

      // 更新坐标
      this.curJ += 1;
      if (this.curJ >= this.wordCountPerLine) {
        this.curJ = 0;
        this.curI += 1;

        // 翻页
        if (this.curI >= this.lineCount) {
          this.curI = this.curJ = 0;
          $event.target.value = '';
          this.pageIndex += 1;
          this.refreshInputs();

          if (this.pageIndex >= this.pageCount) {
            this.pageIndex = 0;
          }
        }
      }
      this.selectInput(this.curI, this.curJ);
    }
  }

  onInputKeyDown($event) {
  }

  onInputClick() {
    for (let i = this.lineCount - 1; i >= 0; i--) {
      for (let j = this.wordCountPerLine - 1; j >= 0; j--) {
        if (this.wordDetails[i * this.wordCountPerLine + j + this.wordsOnPage].inputValue.trim().length <= 0) {
          this.curI = i;
          this.curJ = j;
          this.selectInput(i, j);
        }
      }
    }
  }

  onFinished($event) {
    this.isFinished = true;
    this.saveTypingInfo();
  }

  onRepaint() {
    setTimeout(() => {
      const now = new Date();
      const milSeconds = now.getTime() - this.practice.practiceTime.getTime();
      this.printSpeed = this.practice.totalCount * 1000.0 * 60 / milSeconds;
      if (this.config.autoRefresh) {
        this.cdRef.markForCheck();
      }
    });
  }

  focusMe() {
    this.selectInput(this.curI, this.curJ);
  }

  saveTypingInfo() {
    console.log("savingTypingInfo");
    // 确保有打字
    if ((this.curI + this.curJ + this.pageIndex) > 0) {
      const now = new Date();
      this.practice.practiceDuration = now.getTime() - this.practice.practiceTime.getTime();
      console.log(this.practice.practiceDuration);
      this.practiceService.save(this.practice, this.wordDetails).subscribe(
        tap(info => console.log(info), ()=>console.error)
      );
    }
  }

  private selectInput(i, j) {
    const selIndex = i * this.wordCountPerLine + j;
    const selInputId = 'wi' + selIndex;
    document.getElementById(selInputId).focus();
  }

  getInputClass(i, j) {
    const inputIndex = i * this.wordCountPerLine + j + this.wordsOnPage;

    if (this.wordDetails !== null && this.wordDetails.length > inputIndex && this.wordDetails[inputIndex] !== undefined) {
      if (this.wordDetails[inputIndex].inputValue.trim().length > 0 && this.wordDetails[inputIndex].isWrong) {
        return 'wordInput font-red';
      }
      if (this.config.tipsOnHard && !this.config.isMarch && this.wordDetails[inputIndex].typingDuration > this.config.hardTime) {
        return 'wordInput font-pink';
      }
      if (this.config.tipsOnExtra && !this.config.isMarch && this.wordDetails[inputIndex].isExtra) {
        return 'wordInput font-purple';
      }
    }
    return 'wordInput';
  }

  get currentIndex(): number {
    return this.curI * this.wordCountPerLine + this.curJ;
  }

  get currentIndexWithPage(): number {
    return this.currentIndex + this.pageIndex * this.wordPerPage;
  }

  get wordPerPage(): number {
    return this.wordCountPerLine * this.lineCount;
  }

  get wordsOnPage(): number {
    return this.pageIndex * this.wordPerPage;
  }
}
