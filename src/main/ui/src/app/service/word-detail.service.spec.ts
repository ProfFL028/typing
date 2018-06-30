import { TestBed, inject } from '@angular/core/testing';

import { WordDetailService } from './word-detail.service';

describe('WordDetailService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [WordDetailService]
    });
  });

  it('should be created', inject([WordDetailService], (service: WordDetailService) => {
    expect(service).toBeTruthy();
  }));
});
