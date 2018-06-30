import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ConfigEntity} from '../shared/entity/config.entity';

@Component({
  selector: 'app-typing-configure',
  templateUrl: './typing-configure.component.html',
  styleUrls: ['./typing-configure.component.css']
})
export class TypingConfigureComponent implements OnInit {

  @Input()
  config: ConfigEntity;

  @Output()
  configChange = new EventEmitter<ConfigEntity>();

  @Output()
  refreshClick = new EventEmitter();

  constructor() {

  }

  ngOnInit() {
  }

  onConfigChange() {
    this.configChange.emit(this.config);
  }

  onRefreshClick($event, config) {
    this.refreshClick.emit({$event, config});
  }

}
