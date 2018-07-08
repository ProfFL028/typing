
export class AnalyzedWordEntity {
  word: string;
  inputChars: string;
  avgDuration?: number;
  minDuration?: number;
  maxDuration?: number;
  wrongCount?: number;
  extraCount?: number;
  backspaceCount?: number;
  enterCount?: number;
}
