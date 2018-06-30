import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TypingConfigureComponent } from './typing-configure.component';

describe('TypingConfigureComponent', () => {
  let component: TypingConfigureComponent;
  let fixture: ComponentFixture<TypingConfigureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TypingConfigureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TypingConfigureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
