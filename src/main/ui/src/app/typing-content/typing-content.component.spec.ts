import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypingContentComponent } from './typing-content.component';

describe('TypingContentComponent', () => {
  let component: TypingContentComponent;
  let fixture: ComponentFixture<TypingContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypingContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypingContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
