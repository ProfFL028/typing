import {WordEntity} from './word.entity';

export class WordDetailEntity {
  paramId: number;
  practiceId: number;
  word: WordEntity;
  typingDuration: number;
  inputChars: string;
  inputValue: string;

  backspaceEntered: boolean;
  enterEntered: boolean;
  isWrong: boolean;
  isExtra: boolean;

  inputKeys: number;

  constructor() {
    this.reset();
  }

  subKeys() {
    this.inputKeys -= 1;
    if (this.inputKeys < 0) {
      this.inputKeys = 0;
    }
    this.isExtra = this.word.inputChars.length < 4 && this.inputKeys > this.word.inputChars.length;
  }

  addKeys() {
    this.inputKeys += 1;
    if (this.inputKeys > 4) {
      this.inputKeys = 4;
    }
    this.isExtra = this.inputKeys > this.word.inputChars.length;
  }

  reset() {
    this.typingDuration = 0;
    this.isWrong = false;
    this.isExtra = false;
    this.backspaceEntered = false;
    this.enterEntered = false;
    this.inputChars = '';

    this.inputKeys = 0;
    this.inputValue = '';
  }

  appendChar(inputChar) {
    this.inputChars += inputChar + "+";
  }

  updateValue(newValue) {
    this.inputValue = newValue;
    this.isWrong = this.inputValue !== this.word.word
  }
}
