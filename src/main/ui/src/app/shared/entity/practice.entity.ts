export class PracticeEntity {
  paramId: number;
  practiceTime: Date;
  practiceDuration: number;
  totalCount: number;
  rightCount: number;
  enterCount: number;
  backspaceCount: number;

  constructor() {
    this.practiceTime = new Date();
    this.practiceDuration = 0;
    this.totalCount = 0;
    this.rightCount = 0;
    this.enterCount = 0;
    this.backspaceCount = 0;
  }
}
